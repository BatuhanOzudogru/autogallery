package com.batuhanozudogru.autogallery.service;

import com.batuhanozudogru.autogallery.dto.DtoGalleristCar;
import com.batuhanozudogru.autogallery.dto.DtoGalleristCarIU;

public interface GalleristCarService {

    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
