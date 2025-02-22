package com.batuhanozudogru.autogallery.service.impl;

import com.batuhanozudogru.autogallery.dto.*;
import com.batuhanozudogru.autogallery.enums.MessageType;
import com.batuhanozudogru.autogallery.exception.BaseException;
import com.batuhanozudogru.autogallery.exception.ErrorMessage;
import com.batuhanozudogru.autogallery.model.Car;
import com.batuhanozudogru.autogallery.model.Gallerist;
import com.batuhanozudogru.autogallery.model.GalleristCar;
import com.batuhanozudogru.autogallery.repository.CarRepository;
import com.batuhanozudogru.autogallery.repository.GalleristCarRepository;
import com.batuhanozudogru.autogallery.repository.GalleristRepository;
import com.batuhanozudogru.autogallery.service.GalleristCarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GalleristCarServiceImpl implements GalleristCarService {

    @Autowired
    private GalleristCarRepository galleristCarRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private GalleristRepository galleristRepository;

    private GalleristCar createGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {
        GalleristCar galleristCar = new GalleristCar();
        galleristCar.setCreatedTime(new Date());
        Optional<Car> optCar = carRepository.findById(dtoGalleristCarIU.getCarId());
        if (optCar.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoGalleristCarIU.getCarId().toString()));
        }
        Optional<Gallerist> optGallerist = galleristRepository.findById(dtoGalleristCarIU.getGalleristId());
        if (optGallerist.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoGalleristCarIU.getGalleristId().toString()));
        }

        galleristCar.setCar(optCar.get());
        galleristCar.setGallerist(optGallerist.get());
        return galleristCar;
    }

    @Override
    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {
        DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoCar dtoCar = new DtoCar();

        DtoAddress dtoAddress = new DtoAddress();

        GalleristCar savedGalleristCar = galleristCarRepository.save(createGalleristCar(dtoGalleristCarIU));

        BeanUtils.copyProperties(savedGalleristCar, dtoGalleristCar);
        BeanUtils.copyProperties(savedGalleristCar.getGallerist(), dtoGallerist);
        BeanUtils.copyProperties(savedGalleristCar.getGallerist().getAddress(), dtoAddress);
        BeanUtils.copyProperties(savedGalleristCar.getCar(), dtoCar);

        dtoGallerist.setAddress(dtoAddress);
        dtoGalleristCar.setGallerist(dtoGallerist);
        //dtoGalleristCar.getGallerist().setAddress(dtoAddress);
        dtoGalleristCar.setCar(dtoCar);

        return dtoGalleristCar;
    }
}
