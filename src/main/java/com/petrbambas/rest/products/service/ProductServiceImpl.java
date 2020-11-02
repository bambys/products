package com.petrbambas.rest.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petrbambas.rest.products.dao.ProductDao;
import com.petrbambas.rest.products.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao ProductDao;
	

	public ProductServiceImpl(ProductDao theProductDao) {
		ProductDao = theProductDao;
	}
	@Override
	@Transactional
	public List<Product> findAll() {
		return ProductDao.findAll();
	}

	/*
	@Override
	@Transactional
	public Product findById(int theId) {
		return ProductDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(Product theProduct) {
		ProductDao.save(theProduct);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		ProductDao.deleteById(theId);
		
	}
	
	*/
}
