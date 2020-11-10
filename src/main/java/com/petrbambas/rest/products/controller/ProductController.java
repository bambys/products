package com.petrbambas.rest.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.petrbambas.rest.products.model.Product;
import com.petrbambas.rest.products.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	private ProductService productService;

	@Autowired
		public ProductController(ProductService theProductService) {
			productService = theProductService;
		}

	@GetMapping("/products")
	public List<Product> findAll() {
		return productService.findAll();
	}

	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable int productId) {
		Product product = productService.findById(productId);
		if (product == null) {
			throw new RuntimeException("Product ID was not found: "+productId);
		}
		else return product;
	}
	
	
}
