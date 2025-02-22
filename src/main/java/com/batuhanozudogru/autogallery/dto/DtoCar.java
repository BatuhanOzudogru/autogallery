package com.batuhanozudogru.autogallery.dto;

import com.batuhanozudogru.autogallery.enums.CarStatusType;
import com.batuhanozudogru.autogallery.enums.CurrencyType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DtoCar extends DtoBase{
    private String brand;

    private String plate;

    private String model;

    private Integer year;

    private BigDecimal price;

    private BigDecimal damagePrice;

    @Enumerated(EnumType.STRING)
    private CarStatusType carStatusType;

    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;
}
