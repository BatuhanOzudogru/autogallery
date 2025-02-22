package com.batuhanozudogru.autogallery.service;

import com.batuhanozudogru.autogallery.dto.DtoSaledCar;
import com.batuhanozudogru.autogallery.dto.DtoSaledCarIU;

public interface SaledCarService {

    public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU);
}
