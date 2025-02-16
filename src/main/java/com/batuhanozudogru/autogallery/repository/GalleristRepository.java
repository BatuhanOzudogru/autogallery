package com.batuhanozudogru.autogallery.repository;

import com.batuhanozudogru.autogallery.model.Gallerist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleristRepository extends JpaRepository<Gallerist, Long> {
}
