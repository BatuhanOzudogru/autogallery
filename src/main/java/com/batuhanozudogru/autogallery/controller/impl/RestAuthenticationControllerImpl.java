package com.batuhanozudogru.autogallery.controller.impl;

import com.batuhanozudogru.autogallery.controller.RestAuthenticationController;
import com.batuhanozudogru.autogallery.controller.RestBaseController;
import com.batuhanozudogru.autogallery.controller.RootEntity;
import com.batuhanozudogru.autogallery.dto.AuthRequest;
import com.batuhanozudogru.autogallery.dto.AuthResponse;
import com.batuhanozudogru.autogallery.dto.DtoUser;
import com.batuhanozudogru.autogallery.dto.RefreshTokenRequest;
import com.batuhanozudogru.autogallery.service.AuthenticationService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthenticationControllerImpl extends RestBaseController implements RestAuthenticationController {


    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest request) {
        return ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    @Override
    public RootEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest request) {
        return ok(authenticationService.authenticate(request));
    }
    @PostMapping("/refreshToken")
    @Override
    public RootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest refreshToken) {
        return ok(authenticationService.refreshToken(refreshToken));
    }
}
