package com.in.ekart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	@Override
	public Product getProduct(Long id) throws Exception {
		Optional<ProductEntity> product = productRepository.findById(id);

		if (product.isPresent()) {
			Product model = new Product();
			BeanUtils.copyProperties(product.get(), model);
			return model;
		} else {
			throw new Exception("Product with Id "+id+" is not found in data base.");
		}
	}

	@Override
	public List<Product> getProduct(String name) throws Exception {

		List<ProductEntity> entities = productRepository.findAllByNameIgnoreCaseLike(name.toUpperCase()+"%");

		List<Product>  products = new ArrayList<Product>();
		entities.stream().forEach(entity -> {
				Product model = new Product();
				BeanUtils.copyProperties(entity, model);
				products.add(model);
		});
		return products;
	}

	@Override
	public List<Product> saveProducts(Product product) {
		
		ProductEntity entity = new ProductEntity();
		BeanUtils.copyProperties(product, entity, "id");//skip copying id
		
		// save the entity
		productRepository.save(entity);
		// return the complete list 
		return getProducts();
	}

	@Override
	public String updateProducts(Product product) {
		
		Optional<ProductEntity> entity = productRepository.findById(product.getId());
		
		if(!entity.isPresent()) {
			return "No Data present in DB with ID: "+product.getId();
		}
		ProductEntity productEntity = new ProductEntity();
		 BeanUtils.copyProperties(product, productEntity);
		 
		 productRepository.save(productEntity);
		
		return "Product with ID:"+product.getId()+" updated successully.";
	}

	@Override
	public String deleteProducts(Long id) {

		Optional<ProductEntity> entity = productRepository.findById(id);
		if (!entity.isPresent()) {
			return "No Data present in DB with ID: " + id;
		}
		productRepository.deleteById(id);
		return "Product with ID:" + id + " deleted successfully.";
	}

}
