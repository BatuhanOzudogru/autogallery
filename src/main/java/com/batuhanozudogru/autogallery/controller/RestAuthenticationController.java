package com.batuhanozudogru.autogallery.controller;

import com.batuhanozudogru.autogallery.dto.AuthRequest;
import com.batuhanozudogru.autogallery.dto.DtoUser;

public interface RestAuthenticationController {

    public RootEntity<DtoUser> register(AuthRequest request);
}
