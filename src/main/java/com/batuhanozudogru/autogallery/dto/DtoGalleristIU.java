package com.batuhanozudogru.autogallery.dto;

import com.batuhanozudogru.autogallery.model.Address;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoGalleristIU {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Long addressId;
}
