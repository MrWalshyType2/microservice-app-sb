package com.brewery.microserviceappsb.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brewery.microserviceappsb.web.model.BeerDTO;
import com.brewery.microserviceappsb.web.service.IBeerService;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
	
	private final IBeerService beerService;

	public BeerController(IBeerService beerService) {
		super();
		this.beerService = beerService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<BeerDTO> getBeerById(@PathVariable("id") UUID id) {
		return new ResponseEntity<BeerDTO>(beerService.getBeerById(id), HttpStatus.OK);
	}
}