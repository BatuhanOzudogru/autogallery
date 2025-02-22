package com.batuhanozudogru.autogallery.service.impl;

import com.batuhanozudogru.autogallery.dto.*;
import com.batuhanozudogru.autogallery.enums.CarStatusType;
import com.batuhanozudogru.autogallery.enums.MessageType;
import com.batuhanozudogru.autogallery.exception.BaseException;
import com.batuhanozudogru.autogallery.exception.ErrorMessage;
import com.batuhanozudogru.autogallery.helper.DateUtils;
import com.batuhanozudogru.autogallery.model.Car;
import com.batuhanozudogru.autogallery.model.Customer;
import com.batuhanozudogru.autogallery.model.SaledCar;
import com.batuhanozudogru.autogallery.repository.CarRepository;
import com.batuhanozudogru.autogallery.repository.CustomerRepository;
import com.batuhanozudogru.autogallery.repository.GalleristRepository;
import com.batuhanozudogru.autogallery.repository.SaledCarRepository;
import com.batuhanozudogru.autogallery.service.CurrencyRatesService;
import com.batuhanozudogru.autogallery.service.SaledCarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Optional;

@Service
public class SaledCarServiceImpl implements SaledCarService {

    @Autowired
    private SaledCarRepository saledCarRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private GalleristRepository galleristRepository;
    @Autowired
    private CurrencyRatesService currencyRatesService;


    public BigDecimal convertCustomerAmountToUSD(Customer customer){
        String currentDate = DateUtils.getCurrentDate(new Date());

        CurrencyRatesResponse currencyRates = currencyRatesService.getCurrencyRates(currentDate, currentDate);

        BigDecimal usd = new BigDecimal(currencyRates.getItems().get(0).getUsd());
        BigDecimal customerUSDAmount = customer.getAccount().getAmount().divide(usd, 2, RoundingMode.HALF_UP);
        return  customerUSDAmount;
    }

    public BigDecimal remainingAmount(Customer customer, Car car){
       BigDecimal customerUSDAmount = convertCustomerAmountToUSD(customer);
       BigDecimal remainingUSD = customerUSDAmount.subtract(car.getPrice());
       CurrencyRatesResponse currencyRates = currencyRatesService.getCurrencyRates(DateUtils.getCurrentDate(new Date()), DateUtils.getCurrentDate(new Date()));

       return remainingUSD.multiply(new BigDecimal(currencyRates.getItems().get(0).getUsd()));
    }
    public boolean checkAmount(DtoSaledCarIU dtoSaledCarIU) {
        Optional<Customer> optCustomer = customerRepository.findById(dtoSaledCarIU.getCustomerId());
        if (optCustomer.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoSaledCarIU.getCustomerId().toString()));
        }
        Optional<Car> optCar= carRepository.findById(dtoSaledCarIU.getCarId());
        if (optCar.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoSaledCarIU.getCarId().toString()));
        }

        BigDecimal customerUSDAmount = convertCustomerAmountToUSD(optCustomer.get());
        if(customerUSDAmount.compareTo(optCar.get().getPrice())==0 || customerUSDAmount.compareTo(optCar.get().getPrice())>0){
            return true;
        }
        return false;
    }

    private SaledCar createSaledCar(DtoSaledCarIU dtoSaledCarIU){
        SaledCar saledCar = new SaledCar();
        saledCar.setCreatedTime(new Date());

        saledCar.setCustomer(customerRepository.findById(dtoSaledCarIU.getCustomerId()).orElse(null));
        saledCar.setGallerist(galleristRepository.findById(dtoSaledCarIU.getGalleristId()).orElse(null));
        saledCar.setCar(carRepository.findById(dtoSaledCarIU.getCarId()).orElse(null));

        return saledCar;
    }

    public boolean checkCarStatus(Long carId){
        Optional<Car> optCar = carRepository.findById(carId);

        if(optCar.isPresent() && optCar.get().getCarStatusType().name().equals(CarStatusType.SOLD.name())){
            return false;
        }
        return true;
    }
    @Override
    public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU) {
        if(!checkCarStatus(dtoSaledCarIU.getCarId())){
            throw new BaseException(new ErrorMessage(MessageType.CAR_STATUS_IS_SOLD,dtoSaledCarIU.getCarId().toString()));
        }

        if(!checkAmount(dtoSaledCarIU)){
            throw new BaseException(new ErrorMessage(MessageType.NOT_ENOUGH_AMOUNT,""));
        }


        SaledCar savedSaledCar = saledCarRepository.save(createSaledCar(dtoSaledCarIU));

        Car car = savedSaledCar.getCar();
        car.setCarStatusType(CarStatusType.SOLD);
        carRepository.save(car);

        Customer customer = savedSaledCar.getCustomer();
        customer.getAccount().setAmount(remainingAmount(customer,car));
        customerRepository.save(customer);


        return toDto(savedSaledCar);
    }

    public DtoSaledCar toDto(SaledCar saledCar){
        DtoSaledCar dtoSaledCar = new DtoSaledCar();
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoCar dtoCar = new DtoCar();

        BeanUtils.copyProperties(saledCar,dtoSaledCar);
        BeanUtils.copyProperties(saledCar.getCustomer(),dtoCustomer);
        BeanUtils.copyProperties(saledCar.getGallerist(),dtoGallerist);
        BeanUtils.copyProperties(saledCar.getCar(),dtoCar);

        dtoSaledCar.setCustomer(dtoCustomer);
        dtoSaledCar.setGallerist(dtoGallerist);
        dtoSaledCar.setCar(dtoCar);

        return dtoSaledCar;
    }
}
