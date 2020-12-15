package com.brewery.microserviceappsb.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.brewery.microserviceappsb.web.model.CustomerDTO;

@Service
public class CustomerService implements ICustomerService {

	@Override
	public CustomerDTO getCustomerById(UUID id) {
		return CustomerDTO.builder()
						  .id(UUID.randomUUID())
						  .name("Fred")
						  .build();
	}

}
