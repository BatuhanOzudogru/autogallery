package com.batuhanozudogru.autogallery.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DtoCustomer extends DtoBase{

    private String firstName;

    private String lastName;

    private String tckn;

    private Date birthDate;

    private DtoAddress address;

    private DtoAccount account;
}
