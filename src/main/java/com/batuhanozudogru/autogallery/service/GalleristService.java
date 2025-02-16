package com.batuhanozudogru.autogallery.service;

import com.batuhanozudogru.autogallery.dto.DtoGallerist;
import com.batuhanozudogru.autogallery.dto.DtoGalleristIU;

public interface GalleristService {

    public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU);
}
