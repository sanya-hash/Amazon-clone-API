package com.clone.amazon.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.clone.amazon.collections.Product;
import com.clone.amazon.collections.Rating;
import com.clone.amazon.model.ProductDto;

public interface ProductService {
	
	Product createProducts(Product product);
	Page<Product> getAll(String title, String sort, String fields, int page, Integer limit,String category,String brand,String color);
	Product getProduct(String id);
	String addRating(Rating rating, String prodId);
    public List<Product> getAllProducts();
    Product updateProductDetails(ProductDto productDto);
    String deleteProduct(String id);
}