package com.in.ekart.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.in.ekart.entity.ProductEntity;
import com.in.ekart.respository.ProductRepository;

@Component
public class DataLoader {

    @Autowired
    private ProductRepository repo;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
    	List<ProductEntity> products = new ArrayList<ProductEntity>();
    	ProductEntity product = null;
    	product = new ProductEntity();
    	product.setName("One Plus 6T");
    	product.setDescription("Smart phone");
    	product.setPrice(49000.97);
    	products.add(product);
    	
    	product = new ProductEntity();
    	product.setName("One Plus 7T");
    	product.setDescription("Smart phone");
    	product.setPrice(48000.97);
    	products.add(product);
    	
    	product = new ProductEntity();
    	product.setName("POCO X2");
    	product.setDescription("Smart phone");
    	product.setPrice(20000.97);
    	products.add(product);
    	
    	product = new ProductEntity();
    	product.setName("POCO F1");
    	product.setDescription("Smart phone");
    	product.setPrice(20000.97);
    	products.add(product);
    	
        repo.saveAll(products);
    }
}
