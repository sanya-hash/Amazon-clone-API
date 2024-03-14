package com.clone.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.amazon.collections.Color;
import com.clone.amazon.service.ColorService;


@RestController
@RequestMapping("/color/")
public class ColorController {
	
	@Autowired
	private ColorService colorService;
	
	@PostMapping
	public List<Color> pushData(@RequestBody List<Color> colors){
		return colorService.saveAllData(colors);
	}
	
	@GetMapping
	public List<Color> getAllData(){
		return colorService.getAllColor();
	}


}
