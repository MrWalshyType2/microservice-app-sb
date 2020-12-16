package com.brewery.microserviceappsb.web.service.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.brewery.microserviceappsb.web.model.v2.BeerDTO;
import com.brewery.microserviceappsb.web.model.v2.BeerStyle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("BeerServiceV2")
public class BeerService implements IBeerService {
	
	@Override
	public BeerDTO getBeerById(UUID id) {
		return BeerDTO.builder()
				      .id(UUID.randomUUID())
				      .name("Kracken")
				      .beerStyle(BeerStyle.ALE)
				      .build();
	}

	@Override
	public BeerDTO createBeer(BeerDTO beer) {
		return BeerDTO.builder()
					  .id(UUID.randomUUID())
					  .name("FalkeAle")
					  .beerStyle(BeerStyle.ALE)
					  .build();
	}

	@Override
	public void updateBeerById(UUID id, BeerDTO beer) {
		// TODO: write update code
	}

	@Override
	public void deleteBeerById(UUID id) {
		// TODO Auto-generated method stub
		log.debug("Deleting a beer...");
	}

}
