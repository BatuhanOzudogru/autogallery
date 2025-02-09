package com.batuhanozudogru.autogallery.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAddress extends DtoBase{

    @NotEmpty
    private String city;

    @NotEmpty
    private String district;

    @NotEmpty
    private String street;

    @NotEmpty
    private String neighborhood;

}
