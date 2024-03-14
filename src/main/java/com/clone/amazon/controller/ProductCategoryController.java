package com.clone.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.amazon.collections.ProdCategory;
import com.clone.amazon.service.ProductCategoryService;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/category/")
public class ProductCategoryController {
	
	@Autowired
	private ProductCategoryService categoryService;
	
	 @GetMapping
	    public List<ProdCategory> getAllCategories() {
	        return categoryService.getAllCategories();
	    }
	
	 @PostMapping
	 public List<ProdCategory> saveAllData(@RequestBody List<ProdCategory> products){
		 return categoryService.saveAllData(products);
	 }
	

}
