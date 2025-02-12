package com.batuhanozudogru.autogallery.controller;

import com.batuhanozudogru.autogallery.dto.DtoCustomer;
import com.batuhanozudogru.autogallery.dto.DtoCustomerIU;

public interface RestCustomerController {

    public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);
}
