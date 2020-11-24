package com.petrbambas.rest.products.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petrbambas.rest.products.dao.ProductDao;
import com.petrbambas.rest.products.dto.ProductWarehouseStock;
import com.petrbambas.rest.products.model.Product;

@Service
public class MapService {

    @Autowired
    private ProductDao productDao;
    
    @Autowired
    private ModelMapper modelMapper;

    public List<ProductWarehouseStock> getAllProductsWarehousesStocks() {
       return ((List<Product>) productDao
                .findAll())
                .stream()
                .map(this::convertToProductWarehouseStockDTO)
                .collect(Collectors.toList());
	}

    private ProductWarehouseStock convertToProductWarehouseStockDTO(Product product) {
    	ProductWarehouseStock pws = new ProductWarehouseStock();
    	pws.setProduct_id(product.getId());
    	pws.setCode(product.getCode()); 
    	pws.setDescription(product.getDescription());
        /*userLocationDTO.setUsername(user.getUsername());
        Location location = user.getLocation();
        userLocationDTO.setLat(location.getLat());
        userLocationDTO.setLng(location.getLng());
        userLocationDTO.setPlace(location.getPlace());
        */
        return pws;      
    }
    
/*    private ProductWarehouseStock convertToProductWarehouseStockDTO(Product product) { 
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        ProductWarehouseStock productWarehouseStock = modelMapper
                .map(product, ProductWarehouseStock.class);	
        return productWarehouseStock;
    }
*/    
}
