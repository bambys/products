package com.petrbambas.rest.products.dto;

import java.math.BigDecimal;

/* special class that combines data of three classes: Product, Warehouse and Stock
without using collections, this class is used in the MapService class*/

public class ProductWarehouseStock {

	private int product_id;
	private String code;
	private String description;
	private int warehouse_id;
	private String warehouse;
	private BigDecimal quantity;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}
