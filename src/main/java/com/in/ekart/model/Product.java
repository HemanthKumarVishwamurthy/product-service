package com.in.ekart.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
	private Long id;
	
	private String name;
	
	private String description;
	
	private Double price;
}
