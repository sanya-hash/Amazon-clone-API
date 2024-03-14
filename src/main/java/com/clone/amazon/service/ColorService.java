package com.clone.amazon.service;

import java.util.List;

import com.clone.amazon.collections.Color;


public interface ColorService {
	List<Color> saveAllData(List<Color> colors);
	
	List<Color> getAllColor();
	Color getColorById(String id);


}
