package com.batuhanozudogru.autogallery.controller.impl;

import com.batuhanozudogru.autogallery.controller.RestBaseController;
import com.batuhanozudogru.autogallery.controller.RestCurrencyRatesController;
import com.batuhanozudogru.autogallery.controller.RootEntity;
import com.batuhanozudogru.autogallery.dto.CurrencyRatesResponse;
import com.batuhanozudogru.autogallery.service.CurrencyRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/currency-rates")
public class RestCurrencyRatesControllerImpl extends RestBaseController implements RestCurrencyRatesController {

    @Autowired
    private CurrencyRatesService currencyRatesService;

    @GetMapping
    @Override
    public RootEntity<CurrencyRatesResponse> getCurrencyRates(@RequestParam String startDate,@RequestParam String endDate) {
        return ok(currencyRatesService.getCurrencyRates(startDate,endDate));
    }
}
