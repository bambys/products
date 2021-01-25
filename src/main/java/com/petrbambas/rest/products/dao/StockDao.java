package com.petrbambas.rest.products.dao;

import java.util.List;

import com.petrbambas.rest.products.model.Stock;

public interface StockDao {
	public List<Stock> findAll();

	public List<Stock> findByProductId(int id);
	
}
