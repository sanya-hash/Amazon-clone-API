package com.clone.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.amazon.collections.Brand;
import com.clone.amazon.service.BrandService;


@RestController
@RequestMapping("/brand/")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@PostMapping
	public List<Brand> pushData(@RequestBody List<Brand> brands){
		return brandService.saveAllData(brands);
	}
	
	@GetMapping
	public List<Brand> getData(){
		return brandService.getAllData();
	}

}
