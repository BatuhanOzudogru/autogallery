package com.batuhanozudogru.autogallery.service;

import com.batuhanozudogru.autogallery.dto.DtoAccount;
import com.batuhanozudogru.autogallery.dto.DtoAccountIU;

public interface AccountService{

    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
}
