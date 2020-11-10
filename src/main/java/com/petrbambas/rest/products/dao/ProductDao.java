package com.petrbambas.rest.products.dao;

import java.util.List;
import com.petrbambas.rest.products.model.Product;

public interface ProductDao {
	public List<Product> findAll();

	public Product findById(int id);
	
//	public void save(Product product);
	
//	public void deleteById(int id);
}
