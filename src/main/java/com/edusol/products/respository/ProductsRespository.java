package com.edusol.products.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusol.products.model.Products;

public interface ProductsRespository extends JpaRepository<Products,Integer> {
	
	List<Products> findByCategory(String category);
	List<Products> findByPrice(float price);
	List<Products> findByPriceAndCategory(float price, String category);
	List<Products> findByPriceBetween(float min, float max);
	List<Products> findByPriceBetweenAndCategory(float min, float max, String category);
	

}
