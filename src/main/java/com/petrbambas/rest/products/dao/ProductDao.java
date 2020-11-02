package com.petrbambas.rest.products.dao;

import java.util.List;

import com.petrbambas.rest.products.model.Product;

public interface ProductDao {
	public List<Product> findAll();
}
