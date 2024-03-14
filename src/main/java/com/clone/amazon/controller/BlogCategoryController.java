package com.clone.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.amazon.collections.BlogCategory;
import com.clone.amazon.service.BlogCategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/blogcategory/")
public class BlogCategoryController {

	@Autowired
	private BlogCategoryService blogCategoryService;
	
	@PostMapping
	public List<BlogCategory> pushData(@RequestBody List<BlogCategory> blogcats){
		return blogCategoryService.saveAllData(blogcats);
	}

}
