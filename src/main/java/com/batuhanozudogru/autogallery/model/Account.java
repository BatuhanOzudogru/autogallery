package com.batuhanozudogru.autogallery.model;

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
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity{

   private String accountNo;

   private String iban;

   private BigDecimal amount;

   @Enumerated(EnumType.STRING)
   private CurrencyType currencyType;


}
