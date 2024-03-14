package com.clone.amazon.service;

import java.util.List;

import com.clone.amazon.collections.Brand;


public interface BrandService {
	
	List<Brand> saveAllData(List<Brand> allBrands);
	List<Brand> getAllData();
	Brand getBrandById(String id);

}
