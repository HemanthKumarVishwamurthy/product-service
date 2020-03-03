package com.in.ekart.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.in.ekart.model.Product;
import com.in.ekart.service.ProductService;
import com.in.ekart.service.ProductServiceImpl;

public class ProductControllerTest {
	
	@Mock
	private ProductController mockProductController;
	
	@Mock
	private ProductService mockProductService;
	
	@Before
	public void setup() {
		mockProductController = new ProductController();
		mockProductService = Mockito.mock(ProductServiceImpl.class);
		
		ReflectionTestUtils.setField(mockProductController, "productService", mockProductService);
	}
	
	@Test
	public void TestGetProducts() throws Exception {
		Mockito.when(mockProductService.getProducts()).thenReturn(getProductList());
		
		List<Product> response = mockProductController.getProducts();
		
		assertEquals("Iphone", response.get(0).getName());
	}
	
	@Test
	public void TestGetProducts_Exception() throws Exception {
		Mockito.when(mockProductService.getProducts()).thenReturn(new ArrayList<>());
		try {
			List<Product> response = mockProductController.getProducts();
		} catch (Exception e) {
			assertEquals("No Products available in the Store.", e.getMessage());
		}
	}
	
	@Test
	public void TestGetProductByName() throws Exception {
		Mockito.when(mockProductService.getProduct(Mockito.anyString())).thenReturn(getProductList());

		List<Product> response = mockProductController.getProducts("Iphone");

		assertEquals("Iphone", response.get(0).getName());
	}
	
	@Test(expected = Exception.class)
	public void TestGetProductByName_Exception() throws Exception {
		Mockito.when(mockProductService.getProduct(Mockito.anyString())).thenThrow(new Exception());
		List<Product> response = mockProductController.getProducts("Iphone");
	}

	private List<Product> getProductList() {
		Product product = new Product();
		product.setId(1L);
		product.setName("Iphone");
		product.setDescription("Smart phone");
		product.setPrice(90000.894);
		
		List<Product> products = new ArrayList<>();
		products.add(product);
		return products;
	}
}
