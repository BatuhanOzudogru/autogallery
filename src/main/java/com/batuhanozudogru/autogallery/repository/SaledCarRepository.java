package com.batuhanozudogru.autogallery.repository;

import com.batuhanozudogru.autogallery.model.SaledCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaledCarRepository extends JpaRepository<SaledCar, Long> {

}
