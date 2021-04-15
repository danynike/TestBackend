package com.backend.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.test.model.Customer;
import com.backend.test.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
    private CustomerRepository customer;

    @Override
    public Iterable<Customer> CustomerList() {
        return customer.findAll();
    }

    @Override
    public void CustomerDelete(Long id) {
        this.customer.delete(new Customer(id));
    }

    @Override
    public void CustomerAdd(Customer product) {
        this.customer.save(product);
    }

    @Override
    public Long CustomerCount() {
        return this.customer.count();
    }

	@Override
	public void CustomersAdd(List<Customer> product) {
		this.customer.saveAll(product);
	}
	
}