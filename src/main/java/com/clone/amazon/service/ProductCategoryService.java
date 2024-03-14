package com.clone.amazon.service;

import java.util.List;

import com.clone.amazon.collections.ProdCategory;



public interface ProductCategoryService {
	
	 List<ProdCategory> getAllCategories();
	 List<ProdCategory> saveAllData(List<ProdCategory> productCategories);
	 ProdCategory getCategoryById(String id);

	 

}
