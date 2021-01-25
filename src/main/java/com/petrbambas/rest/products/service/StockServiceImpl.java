package com.petrbambas.rest.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.petrbambas.rest.products.dao.StockDao;
import com.petrbambas.rest.products.model.Stock;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockDao stockDao;
	
	// returns the quantity of concrete product on all warehouses 
	@Override
	@Transactional
	public List<Stock> findStockByProductId(int id) {
		return stockDao.findByProductId(id);
	}
}
