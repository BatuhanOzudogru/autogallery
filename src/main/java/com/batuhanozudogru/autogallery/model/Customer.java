package com.batuhanozudogru.autogallery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity{

    private String firstName;

    private String lastName;

    private String tckn;

    private Date birthDate;

    @OneToOne
    private Address address;

    @OneToOne
    private Account account;
}
