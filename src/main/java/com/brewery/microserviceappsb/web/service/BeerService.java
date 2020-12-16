package com.brewery.microserviceappsb.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.brewery.microserviceappsb.web.model.BeerDTO;

@Service
public class BeerService implements IBeerService {

	@Override
	public BeerDTO getBeerById(UUID id) {
		return BeerDTO.builder()
				      .id(UUID.randomUUID())
				      .name("Kracken")
				      .beerStyle("Ale")
				      .build();
	}

	@Override
	public BeerDTO createBeer(BeerDTO beer) {
		return BeerDTO.builder()
					  .id(UUID.randomUUID())
					  .name("FalkeAle")
					  .beerStyle("Fake Ale")
					  .build();
	}

	@Override
	public void updateBeerById(UUID id, BeerDTO beer) {
		// TODO: write update code
	}

}
