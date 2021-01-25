package com.petrbambas.rest.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petrbambas.rest.products.model.Product;
import com.petrbambas.rest.products.service.MapService;
import com.petrbambas.rest.products.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService theProductService, MapService mapService) {
		this.productService = theProductService;
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
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		product.setId(0);
		productService.save(product);
		return product;		
	}
	
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product) {
		productService.save(product);
		return product;
	}
	
	@DeleteMapping("/products/{ProductId}")
	public String deleteProduct(@PathVariable int ProductId) {
		Product theProduct = productService.findById(ProductId);
		if (theProduct == null) {
			throw new RuntimeException("Product was not found: "+ProductId);
		}
		productService.deleteById(ProductId);
		return ("Product was deleted: "+ProductId);
	}
	
}
