package com.brewery.microserviceappsb.web.service.v2;

import java.util.UUID;

import com.brewery.microserviceappsb.web.model.v2.BeerDTO;

public interface IBeerService {

	BeerDTO getBeerById(UUID id);

	BeerDTO createBeer(BeerDTO beer);

	void updateBeerById(UUID id, BeerDTO beer);

	void deleteBeerById(UUID id);
}
