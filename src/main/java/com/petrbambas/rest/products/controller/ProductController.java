package com.petrbambas.rest.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petrbambas.rest.products.dto.ProductWarehouseStock;
import com.petrbambas.rest.products.model.Product;
import com.petrbambas.rest.products.service.MapService;
import com.petrbambas.rest.products.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	private ProductService productService;
	private MapService mapService;
	
	@Autowired
		public ProductController(ProductService theProductService, MapService mapService) {
			this.productService = theProductService;
			this.mapService = mapService;
		}

	
    @GetMapping("/map")
    //@ResponseBody
    public List<ProductWarehouseStock> getAllUsersLocation() {
        List <ProductWarehouseStock> pws = mapService.getAllProductsWarehousesStocks();
        return pws;
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
