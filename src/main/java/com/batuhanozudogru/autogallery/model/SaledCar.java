package com.batuhanozudogru.autogallery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "saled_car", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"gallerist_id", "car_id", "customer_id"}, name = "UQ_SALED_CAR")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaledCar extends BaseEntity {

    @ManyToOne
    private Gallerist gallerist;
    @ManyToOne
    private Car car;
    @ManyToOne
    private Customer customer;
}
