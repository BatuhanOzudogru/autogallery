package com.batuhanozudogru.autogallery.service;

import com.batuhanozudogru.autogallery.dto.AuthRequest;
import com.batuhanozudogru.autogallery.dto.DtoUser;

public interface AuthenticationService {


    public DtoUser register(AuthRequest request);
}
