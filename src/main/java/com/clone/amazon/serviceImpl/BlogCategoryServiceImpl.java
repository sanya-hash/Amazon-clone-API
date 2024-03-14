package com.clone.amazon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.amazon.collections.BlogCategory;
import com.clone.amazon.repositories.BlogCategoryRepository;
import com.clone.amazon.service.BlogCategoryService;


@Service
public class BlogCategoryServiceImpl implements BlogCategoryService{
	@Autowired
	private BlogCategoryRepository blogCategoryRepository;

	@Override
	public List<BlogCategory> saveAllData(List<BlogCategory> blogCategories) {
	
		return blogCategoryRepository.saveAll(blogCategories);
	}

}
