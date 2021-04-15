package com.backend.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.test.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
