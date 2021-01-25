package com.petrbambas.rest.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petrbambas.rest.products.dto.ProductWarehouseStock;
import com.petrbambas.rest.products.service.MapService;

@RestController
@RequestMapping("/api")
public class InventoryController {

	private MapService mapService;

	@Autowired
	public InventoryController(MapService mapService) {
		this.mapService = mapService;
	}

	// returns combination of the data of classes Product, Warehouse and Stocks - inventory
	@GetMapping("/inventory")
	public List<ProductWarehouseStock> getAllUsersLocation() {
		List<ProductWarehouseStock> pws = mapService.getAllProductsWarehousesStocks();
		return pws;
	}

}
