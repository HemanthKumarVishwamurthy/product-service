package com.in.ekart.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.in.ekart.entity.ProductEntity;
import com.in.ekart.model.Product;
import com.in.ekart.respository.ProductRepository;
import com.in.ekart.service.ProductService;
import com.in.ekart.service.ProductServiceImpl;

public class ProductControllerTest {

	@Mock
	private ProductController controller;
	
	@Mock
	private ProductService productService;
	
	@Mock
	private ProductRepository repository;
	
	@Before
	public void setUp() {
		controller = new ProductController();
		productService = new ProductServiceImpl();
		repository = Mockito.mock(ProductRepository.class);
		
		ReflectionTestUtils.setField(productService, "productRepository", repository);
		ReflectionTestUtils.setField(controller, "productService", productService);
	}
	
	@Test
	public void TestGetProducts() {
		
		List<ProductEntity> entities = new ArrayList<ProductEntity>();
		
		ProductEntity entity = new ProductEntity();
		entity.setId(1L);
		entity.setName("Laptop");
		entity.setDescription("New Gen Laptop from Dell");
		entity.setPrice(123000.00);
		entities.add(entity);
		Mockito.when(repository.findAll()).thenReturn(entities);
		
		
		List<Product> response = controller.getProducts();
		
		assertNotNull(response);
		assertEquals("Laptop", response.get(0).getName());
	}
}
