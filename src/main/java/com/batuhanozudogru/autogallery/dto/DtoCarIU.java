package com.batuhanozudogru.autogallery.dto;

import com.batuhanozudogru.autogallery.enums.CarStatusType;
import com.batuhanozudogru.autogallery.enums.CurrencyType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DtoCarIU {

    @NotNull
    private String brand;

    @NotNull
    private String plate;

    @NotNull
    private String model;

    @NotNull
    private Integer year;

    @NotNull
    private BigDecimal price;

    @NotNull
    private BigDecimal damagePrice;

    @NotNull
    private CarStatusType carStatusType;

    @NotNull
    private CurrencyType currencyType;
}
