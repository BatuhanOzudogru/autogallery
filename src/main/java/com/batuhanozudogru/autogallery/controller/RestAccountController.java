package com.batuhanozudogru.autogallery.controller;

import com.batuhanozudogru.autogallery.dto.DtoAccount;
import com.batuhanozudogru.autogallery.dto.DtoAccountIU;
import jakarta.persistence.criteria.Root;

public interface RestAccountController {

    public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);
}
