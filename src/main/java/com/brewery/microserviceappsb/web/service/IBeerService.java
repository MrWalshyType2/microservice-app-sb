package com.brewery.microserviceappsb.web.service;

import java.util.UUID;

import com.brewery.microserviceappsb.web.model.BeerDTO;

public interface IBeerService {

	BeerDTO getBeerById(UUID id);

	BeerDTO createBeer(BeerDTO beer);

	void updateBeerById(UUID id, BeerDTO beer);
}
