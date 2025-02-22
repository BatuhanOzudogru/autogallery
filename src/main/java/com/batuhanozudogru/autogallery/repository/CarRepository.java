package com.batuhanozudogru.autogallery.repository;

import com.batuhanozudogru.autogallery.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
