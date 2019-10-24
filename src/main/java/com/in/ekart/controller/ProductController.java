package com.in.ekart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(value = "/products/{id}")
	public Product getProducts(@PathVariable Long id) throws Exception{
		System.out.println("START : Get Products");
		Product products = productService.getProduct(id);
		System.out.println("END : Get Products");
		return products;
	}
	
	@GetMapping(value = "/product")
	public List<Product> getProducts(@RequestParam String name) throws Exception{
		System.out.println("START : Get Products");
		List<Product> products = productService.getProduct(name);
		System.out.println("END : Get Products");
		return products;
	}
	
	@PostMapping(value = "/products", consumes = "application/json", produces = "application/json")
	public List<Product> saveProducts(@RequestBody(required = true) Product product) throws Exception{
		System.out.println("START : Save Products");
		List<Product> products = productService.saveProducts(product);
		System.out.println("END : Save Products");
		return products;
	} 
	
	@PutMapping(value = "/products", consumes = "application/json")
	public String updateProducts(@RequestBody(required = true) Product product) throws Exception{
		System.out.println("START : Update Products");
		String products = productService.updateProducts(product);
		System.out.println("END : Update Products");
		return products;
	} 	
	
	@DeleteMapping(value = "/products/{id}", consumes = "application/json")
	public String deleteProducts(@PathVariable Long id) throws Exception{
		System.out.println("START : Delete Products");
		String products = productService.deleteProducts(id);
		System.out.println("END : Delete Products");
		return products;
	} 	
}
