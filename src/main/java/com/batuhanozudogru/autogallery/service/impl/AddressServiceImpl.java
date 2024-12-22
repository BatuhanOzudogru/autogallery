package com.batuhanozudogru.autogallery.service.impl;

import com.batuhanozudogru.autogallery.enums.MessageType;
import com.batuhanozudogru.autogallery.exception.BaseException;
import com.batuhanozudogru.autogallery.exception.ErrorMessage;
import com.batuhanozudogru.autogallery.service.AddressService;

public class AddressServiceImpl implements AddressService {

   public void test() {
         throw new BaseException(new ErrorMessage( MessageType.NO_RECORD_EXIST,null));
    }
}
