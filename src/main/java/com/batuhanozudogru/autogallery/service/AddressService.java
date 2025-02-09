package com.batuhanozudogru.autogallery.service;

import com.batuhanozudogru.autogallery.dto.DtoAddress;
import com.batuhanozudogru.autogallery.dto.DtoAddressIU;

public interface AddressService {

    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);
}
