package com.backend.test.service;

import java.util.List;

import com.backend.test.model.Customer;

public interface CustomerService {

	Iterable<Customer> CustomerList();

    void CustomerDelete(Long id);
    
    void CustomerAdd(Customer product);
    
    void CustomersAdd(List<Customer> product);
    
    Long CustomerCount();
	
}
