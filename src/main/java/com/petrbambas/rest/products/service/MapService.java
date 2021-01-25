package com.petrbambas.rest.products.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petrbambas.rest.products.dao.StockDao;
import com.petrbambas.rest.products.dto.ProductWarehouseStock;
import com.petrbambas.rest.products.model.Stock;

@Service
public class MapService {

	@Autowired
	private StockDao stockDao;

	@Autowired
	private ModelMapper modelMapper;

	public List<ProductWarehouseStock> getAllProductsWarehousesStocks() {
		return ((List<Stock>) stockDao.findAll()).stream().map(this::convertToProductWarehouseStockDTO)
				.collect(Collectors.toList());
	}

	private ProductWarehouseStock convertToProductWarehouseStockDTO(Stock stock) {
		ProductWarehouseStock pws = new ProductWarehouseStock();
		pws.setProduct_id(stock.getProduct().getId());
		pws.setCode(stock.getProduct().getCode());
		pws.setDescription(stock.getProduct().getDescription());
		pws.setWarehouse(stock.getWarehouse().getName());
		pws.setQuantity(stock.getQuantity());
		pws.setWarehouse_id(stock.getWarehouse().getId());

		return pws;
	}

	/* 
	 * private ProductWarehouseStock convertToProductWarehouseStockDTO(Product
	 * product) { modelMapper.getConfiguration()
	 * .setMatchingStrategy(MatchingStrategies.LOOSE); ProductWarehouseStock
	 * productWarehouseStock = modelMapper .map(product,
	 * ProductWarehouseStock.class); return productWarehouseStock; }
	 */
}
