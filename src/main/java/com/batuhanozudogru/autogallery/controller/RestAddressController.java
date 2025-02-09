package com.batuhanozudogru.autogallery.controller;

import com.batuhanozudogru.autogallery.dto.DtoAddress;
import com.batuhanozudogru.autogallery.dto.DtoAddressIU;

public interface RestAddressController {

    public RootEntity<DtoAddress> saveAddress(DtoAddressIU dtoAddressIU);
}
