package com.batuhanozudogru.autogallery.service;

import com.batuhanozudogru.autogallery.dto.DtoCar;
import com.batuhanozudogru.autogallery.dto.DtoCarIU;

public interface CarService {

    public DtoCar saveCar(DtoCarIU dtoCarIU);
}
