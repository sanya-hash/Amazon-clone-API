package com.clone.amazon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.amazon.collections.ProdCategory;
import com.clone.amazon.repositories.ProductCategoryRepository;
import com.clone.amazon.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
	
	@Autowired
	private ProductCategoryRepository categoryRepository;
	
	@Override
    public List<ProdCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

	@Override
	public List<ProdCategory> saveAllData(List<ProdCategory> productCategories) {
		return categoryRepository.saveAll(productCategories);
	}

	@Override
	public ProdCategory getCategoryById(String id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).get();
	}

}
