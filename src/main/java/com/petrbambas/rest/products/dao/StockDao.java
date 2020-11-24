package com.petrbambas.rest.products.dao;

import java.util.List;
import java.util.Set;

import com.petrbambas.rest.products.model.Stock;

public interface StockDao {
	//public List<Product> findAll();

	public List<Stock> findByProductId(int id);
}
