package com.edusol.products.service;

//import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edusol.products.model.Products;
import com.edusol.products.respository.ProductsRespository;
import com.google.gson.JsonObject;

@Service
public class ProductsService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductsRespository productsRespository;
	
	public Object getProducts() {
		
		return productsRespository.findAll();
	}

	public Object addProducts(Products products) {
		logger.info(products.toString());
        productsRespository.save(products);
        logger.info("products added successfully");
        return new ResponseEntity<>("products added successfully",HttpStatus.CREATED);
		//return "products add successfully";
	}

	public Object getProductsById(int id) {
		return productsRespository.findById(id);
	}

	public Object getProductsByCategory(String category) {
		return productsRespository.findByCategory(category);
	}

	public Object getProductsByPrice(float price) {
		return productsRespository.findByPrice(price);
	}

	public Object deleteProducts(int id) {
		try {
		productsRespository.deleteById(id);
		}catch(Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		logger.info("products deleted successfully");
		return new ResponseEntity<>("products deleted successfully",HttpStatus.OK);
			//	return "products deleted successfully";
		}

	public Object getProductsByPriceAndCategory(float price,String category){
		return productsRespository.findByPriceAndCategory(price,category);
	}

	public Object updateProducts(Products products) {
		
		JsonObject response=new JsonObject();
		
		System.out.println("Request products:"+products);
		int id=products.getId();
		try {
		Products prod=productsRespository.getOne(id);
		System.out.println("Request products:"+prod);
		System.out.println("old products:"+prod);
		
		prod.setPrice(products.getPrice());
		System.out.println("new products:"+prod);
		
		productsRespository.save(prod);
		}catch(Exception e) {
			logger.error(e.getMessage());
			
			response.addProperty("StatusCode",404);
			response.addProperty("StatusMessage",e.getMessage());
			
			return new ResponseEntity<>(response.toString(),HttpStatus.NOT_FOUND);	
		}
		logger.info("products updated successfully");
		return new ResponseEntity<>("products updated successfully",HttpStatus.OK);
		//return "products updated successfully";
	}

	public Object getProductsByPriceRange(float min, float max) {
		return productsRespository.findByPriceBetween(min,max);
	}

	public Object getProductsByPriceRangeAndCategory(float min, float max, String category) {
		
		return productsRespository.findByPriceBetweenAndCategory(min,max,category);
	}

	
}
	
