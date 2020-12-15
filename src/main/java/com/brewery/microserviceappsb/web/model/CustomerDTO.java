package com.brewery.microserviceappsb.web.model;

import lombok.Builder;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

	private UUID id;
	private String name;
}
