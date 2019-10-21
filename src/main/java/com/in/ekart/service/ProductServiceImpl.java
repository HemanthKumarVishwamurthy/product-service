package com.in.ekart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.ekart.entity.ProductEntity;
import com.in.ekart.model.Product;
import com.in.ekart.respository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getProducts() {
		System.out.println("START : Get Products in ProductServiceImpl");
		List<ProductEntity> entities = (List<ProductEntity>) productRepository.findAll();
		
		List<Product> products = new ArrayList<Product>();
		
		/*
		 * for (ProductEntity entity : entities) { Product product = new Product();
		 * BeanUtils.copyProperties(entity, product); products.add(product); }
		 */
		
		entities.stream().forEach(entity -> {
			Product product = new Product();
			BeanUtils.copyProperties(entity, product);
			products.add(product);
		});
		
		System.out.println("END : Get Products in ProductServiceImpl");

		return products;
	}

}
