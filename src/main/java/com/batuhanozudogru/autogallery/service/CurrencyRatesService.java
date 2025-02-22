package com.batuhanozudogru.autogallery.service;

import com.batuhanozudogru.autogallery.dto.CurrencyRatesResponse;

public interface CurrencyRatesService {

    public CurrencyRatesResponse getCurrencyRates(String startDate, String endDate);
}
