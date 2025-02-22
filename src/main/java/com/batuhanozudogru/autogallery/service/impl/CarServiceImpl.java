package com.batuhanozudogru.autogallery.service.impl;

import com.batuhanozudogru.autogallery.dto.DtoCar;
import com.batuhanozudogru.autogallery.dto.DtoCarIU;
import com.batuhanozudogru.autogallery.model.Car;
import com.batuhanozudogru.autogallery.repository.CarRepository;
import com.batuhanozudogru.autogallery.service.CarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;


    private Car createCar(DtoCarIU dtoCarIU) {
        Car car = new Car();
        car.setCreatedTime(new Date());
        BeanUtils.copyProperties(dtoCarIU, car);
        return car;
    }
    @Override
    public DtoCar saveCar(DtoCarIU dtoCarIU) {
        DtoCar dtoCar = new DtoCar();
        Car savedCar = carRepository.save(createCar(dtoCarIU));

        BeanUtils.copyProperties(savedCar, dtoCar);
        return dtoCar;
    }
}
