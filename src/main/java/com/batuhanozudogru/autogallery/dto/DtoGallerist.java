package com.batuhanozudogru.autogallery.dto;

import com.batuhanozudogru.autogallery.model.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoGallerist extends DtoBase{

    private String firstName;

    private String lastName;

    private DtoAddress address;
}
