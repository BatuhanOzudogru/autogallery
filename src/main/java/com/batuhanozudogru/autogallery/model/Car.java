package com.batuhanozudogru.autogallery.model;

import com.batuhanozudogru.autogallery.enums.CarStatusType;
import com.batuhanozudogru.autogallery.enums.CurrencyType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseEntity {

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
