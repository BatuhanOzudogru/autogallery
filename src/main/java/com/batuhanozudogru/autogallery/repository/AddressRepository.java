package com.batuhanozudogru.autogallery.repository;

import com.batuhanozudogru.autogallery.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
