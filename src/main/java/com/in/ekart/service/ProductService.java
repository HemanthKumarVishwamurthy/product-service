package com.in.ekart.service;

import java.util.List;

import com.in.ekart.model.Product;

public interface ProductService {

	public List<Product> getProducts();

	public Product getProduct(Long id) throws Exception;

	public List<Product> getProduct(String name) throws Exception;

	public List<Product> saveProducts(Product product);

	public String updateProducts(Product product);

	public String deleteProducts(Long id);

}
