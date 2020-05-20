package org.davromalc.tutorial.controller;

import java.util.List;

import org.davromalc.tutorial.model.Customer;
import org.davromalc.tutorial.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/mongo/customers")
public class CustomerRestController {

	@Autowired
	private CustomerRepository repository;
	
	@RequestMapping("/getall")
	public List<Customer> findAll() {
		final List<Customer> customers = repository.findAll();
		return customers;
	}

	@PostMapping(value = "/add")
	public void save(@RequestBody Customer customer) {
		repository.save(customer);
	}

	@GetMapping("/getbyfirstname/{firstName}")
	public Customer getByFirstName(@PathVariable("firstName") String firstName) {
		return repository.findByFirstName(firstName);
	}

	@GetMapping("/getbylastname/{lastName}")
	public List<Customer> getByLastName(@PathVariable("lastName") String lastName) {
		return repository.findByLastName(lastName);
	}	
}