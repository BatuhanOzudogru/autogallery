package com.batuhanozudogru.autogallery.service.impl;

import com.batuhanozudogru.autogallery.dto.DtoAddress;
import com.batuhanozudogru.autogallery.dto.DtoAddressIU;
import com.batuhanozudogru.autogallery.enums.MessageType;
import com.batuhanozudogru.autogallery.exception.BaseException;
import com.batuhanozudogru.autogallery.exception.ErrorMessage;
import com.batuhanozudogru.autogallery.model.Address;
import com.batuhanozudogru.autogallery.repository.AddressRepository;
import com.batuhanozudogru.autogallery.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
   private AddressRepository addressRepository;
   private Address createAddress(DtoAddressIU dtoAddressIU) {
        Address address = new Address();
        address.setCreatedTime(new Date());

       BeanUtils.copyProperties(dtoAddressIU, address);
        return address;
    }

    @Override
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
        Address savedAddress = addressRepository.save(createAddress(dtoAddressIU));
        DtoAddress dtoAddress = new DtoAddress();
        BeanUtils.copyProperties(savedAddress, dtoAddress);
        return dtoAddress;
    }
}
