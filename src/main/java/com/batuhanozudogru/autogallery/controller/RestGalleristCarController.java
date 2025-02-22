package com.batuhanozudogru.autogallery.controller;

import com.batuhanozudogru.autogallery.dto.DtoGalleristCar;
import com.batuhanozudogru.autogallery.dto.DtoGalleristCarIU;

public interface RestGalleristCarController {

    public RootEntity<DtoGalleristCar> saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
