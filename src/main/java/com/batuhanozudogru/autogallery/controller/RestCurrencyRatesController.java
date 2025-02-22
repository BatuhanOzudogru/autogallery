package com.batuhanozudogru.autogallery.controller;

import com.batuhanozudogru.autogallery.dto.CurrencyRatesResponse;

public interface RestCurrencyRatesController {

    public RootEntity<CurrencyRatesResponse> getCurrencyRates(String startDate, String endDate);
}
