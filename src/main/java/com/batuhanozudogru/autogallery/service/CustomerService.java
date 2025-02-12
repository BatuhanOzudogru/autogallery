package com.batuhanozudogru.autogallery.service;

import com.batuhanozudogru.autogallery.dto.DtoCustomer;
import com.batuhanozudogru.autogallery.dto.DtoCustomerIU;

public interface CustomerService {
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);

}
