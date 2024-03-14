package com.clone.amazon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.amazon.collections.Brand;
import com.clone.amazon.repositories.BrandRepository;
import com.clone.amazon.service.BrandService;


@Service
public class BrandServiceImpl implements BrandService{
	
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public List<Brand> saveAllData(List<Brand> allBrands) {
		return brandRepository.saveAll(allBrands);
	}

	@Override
	public List<Brand> getAllData() {
		return brandRepository.findAll();
	}

	@Override
	public Brand getBrandById(String id) {
		// TODO Auto-generated method stub
		return brandRepository.findById(id).get();
	}

}
