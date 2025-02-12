package com.batuhanozudogru.autogallery.controller.impl;

import com.batuhanozudogru.autogallery.controller.RestBaseController;
import com.batuhanozudogru.autogallery.controller.RestCustomerController;
import com.batuhanozudogru.autogallery.controller.RootEntity;
import com.batuhanozudogru.autogallery.dto.DtoCustomer;
import com.batuhanozudogru.autogallery.dto.DtoCustomerIU;
import com.batuhanozudogru.autogallery.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/api/customer")
public class RestCustomerControllerImpl extends RestBaseController implements RestCustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
        return ok(customerService.saveCustomer(dtoCustomerIU));
    }
}
