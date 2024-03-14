package com.clone.amazon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.amazon.collections.Color;
import com.clone.amazon.repositories.ColorRepository;
import com.clone.amazon.service.ColorService;


@Service
public class ColorServiceImpl implements ColorService{
	
	@Autowired
	private ColorRepository colorRepository;
	@Override
	public List<Color> saveAllData(List<Color> colors) {
		return colorRepository.saveAll(colors);
	}
	@Override
	public List<Color> getAllColor() {
		return colorRepository.findAll();
	}
	@Override
	public Color getColorById(String id) {
		// TODO Auto-generated method stub
		return colorRepository.findById(id).get();
	}

}
