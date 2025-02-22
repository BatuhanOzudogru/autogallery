package com.batuhanozudogru.autogallery.repository;

import com.batuhanozudogru.autogallery.model.GalleristCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleristCarRepository extends JpaRepository<GalleristCar, Long> {
}
