package com.edusol.products;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.products.model.Products;
import com.edusol.products.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductsService productsService;
	
	
	@GetMapping("/get-products")
	public Object getProducts() {
		@SuppressWarnings("unchecked")
		List<Products> products=(List<Products>) productsService.getProducts();
		logger.info(products.toString());
		return products;
	//	return productsService.getProducts();
	}
	
	@PostMapping("/add-products")
	public Object addProducts(@RequestBody Products products) {
		
		logger.info(products.toString());
		
		return productsService.addProducts(products);	
	}
	
	@GetMapping("/get-productsbyid")
	public Object getProductsById(@RequestParam int id) {
		@SuppressWarnings("unchecked")
		List<Products> products=(List<Products>) productsService.getProductsById(id);
		logger.info(products.toString());
		return products;
	//return productsService.getProductsById(id);
	}
	
	@GetMapping("/get-productsbycategory")
	public Object getProductsByCategory(@RequestParam String category) {
		@SuppressWarnings("unchecked")
		List<Products> products=(List<Products>) productsService.getProductsByCategory(category);
		logger.info(products.toString());
		return products ;
		//return productsService.getProductsByCategory(category);
	}
	
	@GetMapping("/get-productsByPriceAndCategory")
	public Object getProductsByPriceAndCategory(@RequestParam float price,@RequestParam String category){
		@SuppressWarnings("unchecked")
		List<Products> products=(List<Products>) productsService.getProductsByPriceAndCategory( price, category);
		logger.info(products.toString());
		return products ;
	//return productsService.getProductsByPriceAndCategory( price, category);
		}
	
	@GetMapping("/get-productsbyprice")
	public Object getProductsByPrice(@RequestParam float price) {
		@SuppressWarnings("unchecked")
		List<Products> products=(List<Products>) productsService.getProductsByPrice(price);
		logger.info(products.toString());
		return products ;
	//	return productsService.getProductsByPrice(price);
		}
	
	@DeleteMapping("/delete-products")
	public Object deleteProducts(@RequestParam int id) {
		
		logger.info("productsid="+id);
		
		return productsService.deleteProducts(id);
	}
	
	@PutMapping("/update-products")
	public Object updateProducts(@RequestBody Products products) {
		return productsService.updateProducts(products);
	}
	
	@GetMapping("/get-productsbypricerange")
	public Object getProductsByPriceRange(@RequestParam float min,float max) {
		@SuppressWarnings("unchecked")
		List<Products> products=(List<Products>) productsService.getProductsByPriceRange(min,max);
		logger.info(products.toString());
		return products ;
	//return productsService.getProductsByPriceRange(min,max);
	}
	
	@GetMapping("/get-productsByPriceRangeAndCategory")
	public Object getProductsByPriceRangeAndCategory(@RequestParam float min,float max,@RequestParam String category){
		@SuppressWarnings("unchecked")
		List<Products> products=(List<Products>) productsService.getProductsByPriceRangeAndCategory( min,max, category);
		logger.info(products.toString());
		return products ;
	//return productsService.getProductsByPriceRangeAndCategory( min,max, category);
	}
}
