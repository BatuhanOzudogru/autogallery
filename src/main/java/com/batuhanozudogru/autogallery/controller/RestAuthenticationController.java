package com.batuhanozudogru.autogallery.controller;

import com.batuhanozudogru.autogallery.dto.AuthRequest;
import com.batuhanozudogru.autogallery.dto.AuthResponse;
import com.batuhanozudogru.autogallery.dto.DtoUser;
import com.batuhanozudogru.autogallery.dto.RefreshTokenRequest;

public interface RestAuthenticationController {

    public RootEntity<DtoUser> register(AuthRequest request);

    public RootEntity<AuthResponse> authenticate(AuthRequest request);

    public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest refreshToken);
}
