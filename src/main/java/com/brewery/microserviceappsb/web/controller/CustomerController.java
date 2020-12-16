package com.brewery.microserviceappsb.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brewery.microserviceappsb.web.model.CustomerDTO;
import com.brewery.microserviceappsb.web.service.ICustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	
	private final ICustomerService customerService;

	public CustomerController(ICustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") UUID id) {
		return new ResponseEntity<CustomerDTO>(customerService.getCustomerById(id), HttpStatus.OK);
	}
	
}
