package com.petrbambas.rest.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petrbambas.rest.products.model.Stock;
import com.petrbambas.rest.products.service.StockService;

@RestController
@RequestMapping("/api")
public class StockController {

	private StockService stockService;

	@Autowired
		public StockController(StockService theStockService) {
			stockService = theStockService;
		}

	@GetMapping("/products/{productId}/stocks")
	public List <Stock> getStocksByProduct(@PathVariable int productId) {
		/*Product product = stockService.findById(productId);
		if (product == null) {
			throw new RuntimeException("Stock ID was not found: "+productId);
		}
		*/
		//else
			return stockService.findStockByProductId(productId);
	}
}
