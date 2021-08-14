package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.repository.ICustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ICustomerRepository customerRepo;
	@GetMapping("/")
	public Page<Customer> getAllCustomers(Pageable pageable){
		return customerRepo.findAll(pageable);
	}
	@PostMapping(value = "/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerRepo.save(customer);
	}
}
