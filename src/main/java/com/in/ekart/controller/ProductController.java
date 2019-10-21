package com.in.ekart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.ekart.model.Product;
import com.in.ekart.service.ProductService;

@RestController
@RequestMapping(value = "/api/v1/ekart")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/products")
	public List<Product> getProducts(){
		System.out.println("START : Get Products");
		List<Product> products = productService.getProducts();
		System.out.println("END : Get Products");
		return products;
	}
}
