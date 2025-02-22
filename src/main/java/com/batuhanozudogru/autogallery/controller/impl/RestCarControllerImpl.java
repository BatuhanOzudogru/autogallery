package com.batuhanozudogru.autogallery.controller.impl;

import com.batuhanozudogru.autogallery.controller.RestBaseController;
import com.batuhanozudogru.autogallery.controller.RestCarController;
import com.batuhanozudogru.autogallery.controller.RootEntity;
import com.batuhanozudogru.autogallery.dto.DtoCar;
import com.batuhanozudogru.autogallery.dto.DtoCarIU;
import com.batuhanozudogru.autogallery.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/car")
public class RestCarControllerImpl extends RestBaseController implements RestCarController {

    @Autowired
    private CarService carService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {
        return ok(carService.saveCar(dtoCarIU));
    }
}
