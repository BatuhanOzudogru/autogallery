package com.batuhanozudogru.autogallery.controller;

import com.batuhanozudogru.autogallery.dto.DtoCar;
import com.batuhanozudogru.autogallery.dto.DtoCarIU;

public interface RestCarController {

    public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);
}
