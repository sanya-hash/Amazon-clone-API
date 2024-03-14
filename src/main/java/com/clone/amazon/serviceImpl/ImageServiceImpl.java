package com.clone.amazon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.amazon.collections.Image;
import com.clone.amazon.repositories.ImageRepository;
import com.clone.amazon.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	private ImageRepository imageRepository;

	@Override
	public List<Image> create(List<Image> image) {
		return imageRepository.saveAll(image);
	}

}
