package com.batuhanozudogru.autogallery.controller;

import com.batuhanozudogru.autogallery.dto.DtoSaledCar;
import com.batuhanozudogru.autogallery.dto.DtoSaledCarIU;

public interface RestSaledCarController {

    public RootEntity<DtoSaledCar> buyCar(DtoSaledCarIU dtoSaledCarIU);
}
