package com.batuhanozudogru.autogallery.service;

import com.batuhanozudogru.autogallery.dto.AuthRequest;
import com.batuhanozudogru.autogallery.dto.AuthResponse;
import com.batuhanozudogru.autogallery.dto.DtoUser;
import com.batuhanozudogru.autogallery.dto.RefreshTokenRequest;

public interface AuthenticationService {


    public DtoUser register(AuthRequest request);

    public AuthResponse authenticate(AuthRequest request);

    public AuthResponse refreshToken(RefreshTokenRequest input);
}
