package com.brewery.microserviceappsb.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.brewery.microserviceappsb.web.model.BeerDTO;
import com.brewery.microserviceappsb.web.service.IBeerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BeerController.class)
@TestInstance(Lifecycle.PER_CLASS)
public class BeerControllerTest {

		@MockBean
		private IBeerService beerService;
		
		@Autowired
		private MockMvc mockMvc;
		
		@Autowired
		private ObjectMapper objectMapper;
		
		private BeerDTO validBeer;
		
		@BeforeAll
		public void setup() {
			validBeer = BeerDTO.builder()
							   .id(UUID.randomUUID())
							   .name("Green")
							   .beerStyle("Cider")
							   .build();
		}
		
		@Test
		public void getBeerById() throws Exception {
			Mockito.when(beerService.getBeerById(Mockito.any(UUID.class))).thenReturn(validBeer);
			
			mockMvc.perform(get("/api/v1/beer/" + validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
				   .andExpect(status().isOk())
				   .andExpect(content().contentType(MediaType.APPLICATION_JSON))
				   .andExpect(jsonPath("$.id", is(validBeer.getId().toString())))
				   .andExpect(jsonPath("$.name", is(validBeer.getName())));
			
			Mockito.verify(beerService).getBeerById(Mockito.any(UUID.class));
		}
		
		@Test
		public void createBeer() throws Exception {
			BeerDTO savedBeer = BeerDTO.builder().id(UUID.randomUUID()).name("BEERRY").build();
			
			validBeer.setId(null);
			String beerAsJson = objectMapper.writeValueAsString(validBeer);
			
			Mockito.when(beerService.createBeer(Mockito.any(BeerDTO.class))).thenReturn(savedBeer);
			
			mockMvc.perform(post("/api/v1/beer/")
					   .contentType(MediaType.APPLICATION_JSON)
					   .content(beerAsJson))
				   .andExpect(status().isCreated());
			
			Mockito.verify(beerService).createBeer(Mockito.any(BeerDTO.class));
		}
		
		@Test
		public void updateBeerById() throws Exception {
			String beerAsJson = objectMapper.writeValueAsString(validBeer);
			
			mockMvc.perform(put("/api/v1/beer/" + validBeer.getId())
				   .contentType(MediaType.APPLICATION_JSON)
				   .content(beerAsJson))
				   .andExpect(status().isNoContent());
			
			Mockito.verify(beerService).updateBeerById(Mockito.any(UUID.class), Mockito.any(BeerDTO.class));
		}
}
