package com.brewery.microserviceappsb.web.service;

import java.util.UUID;

import com.brewery.microserviceappsb.web.model.CustomerDTO;

public interface ICustomerService {

	CustomerDTO getCustomerById(UUID id);

}
