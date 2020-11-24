package com.petrbambas.rest.products.service;

import java.util.List;

import com.petrbambas.rest.products.model.Stock;

public interface StockService {
	
	//public List<Product> findAll();
	
	public List<Stock> findStockByProductId(int id);
	
	//public void save(Product product);
	
	//public void deleteById(int id);\
	
}
