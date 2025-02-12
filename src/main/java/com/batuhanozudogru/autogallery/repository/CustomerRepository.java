package com.batuhanozudogru.autogallery.repository;

import com.batuhanozudogru.autogallery.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
