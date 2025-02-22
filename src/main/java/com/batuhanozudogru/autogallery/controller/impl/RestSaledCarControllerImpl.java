package com.batuhanozudogru.autogallery.controller.impl;

import com.batuhanozudogru.autogallery.controller.RestBaseController;
import com.batuhanozudogru.autogallery.controller.RestSaledCarController;
import com.batuhanozudogru.autogallery.controller.RootEntity;
import com.batuhanozudogru.autogallery.dto.DtoSaledCar;
import com.batuhanozudogru.autogallery.dto.DtoSaledCarIU;
import com.batuhanozudogru.autogallery.service.SaledCarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/saled-car")
public class RestSaledCarControllerImpl extends RestBaseController implements RestSaledCarController {

    @Autowired
    private SaledCarService saledCarService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoSaledCar> buyCar(@Valid @RequestBody DtoSaledCarIU dtoSaledCarIU) {
        return ok(saledCarService.buyCar(dtoSaledCarIU));
    }
}
