package com.batuhanozudogru.autogallery.controller;

import com.batuhanozudogru.autogallery.controller.impl.RestGalleristController;
import com.batuhanozudogru.autogallery.dto.DtoGallerist;
import com.batuhanozudogru.autogallery.dto.DtoGalleristIU;
import com.batuhanozudogru.autogallery.service.GalleristService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/gallerist")
public class RestGalleristControllerImpl extends RestBaseController implements RestGalleristController {
    @Autowired
    private GalleristService galleristService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoGallerist> saveGallerist(@Valid @RequestBody DtoGalleristIU dtoGalleristIU) {
        return ok(galleristService.saveGallerist(dtoGalleristIU));
    }
}
