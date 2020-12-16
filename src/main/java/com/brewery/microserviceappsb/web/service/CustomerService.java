package com.brewery.microserviceappsb.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.brewery.microserviceappsb.web.model.CustomerDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerService implements ICustomerService {

	@Override
	public CustomerDTO getCustomerById(UUID id) {
		log.debug("Getting a customer by id");
		return CustomerDTO.builder()
						  .id(UUID.randomUUID())
						  .name("Fred")
						  .build();
	}

	@Override
	public CustomerDTO createCustomer(CustomerDTO customer) {
		log.debug("Creating a customer");
		customer.setId(UUID.randomUUID());
		return customer;
	}

	@Override
	public void updateCustomerById(UUID id, CustomerDTO customer) {
		log.debug("Updating a customer by id...");
	}

	@Override
	public void deleteCustomerById(UUID id) {
		log.debug("Deleting a customer by id...");
	}

}
