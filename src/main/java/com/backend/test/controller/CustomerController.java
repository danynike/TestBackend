package com.backend.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.test.model.Customer;
import com.backend.test.model.CustomerListContainer;
import com.backend.test.service.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customers;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String customerList(Model model) {
    	Iterable<Customer> it = customers.CustomerList();
    	List<Customer> custs = new ArrayList<>();
    	it.forEach(custs::add);
        CustomerListContainer cusList = new CustomerListContainer();
        cusList.setCustomers(custs);
        model.addAttribute("customerList", cusList);
        return "customer";
    }

    @RequestMapping("/customer/delete/{id}")
    public String customerDelete(@PathVariable("id") Long id, Model model) {
        customers.CustomerDelete(id);
        return "redirect:/customer";
    }

    @RequestMapping("/customer/form")
    public String customerForm(Model model) {
        model.addAttribute("customer", new Customer());  
        return "customerform";
    }

    @RequestMapping(value = "/customer/create", method = RequestMethod.POST)
    public String customerCreate(@ModelAttribute("customer") Customer customer) {
        customers.CustomerAdd(customer);
        return "redirect:/customer";
    }
    
    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String customerProcess(@ModelAttribute("customerList") CustomerListContainer customerListContainer) {
    	List<Customer> custs = customerListContainer.getCustomers();
    	customers.CustomersAdd(custs);
        return "redirect:/customer";
    }
}