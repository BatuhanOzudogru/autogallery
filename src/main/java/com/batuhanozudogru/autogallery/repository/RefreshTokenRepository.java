package com.batuhanozudogru.autogallery.repository;

import com.batuhanozudogru.autogallery.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

}
