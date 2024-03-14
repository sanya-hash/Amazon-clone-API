package com.clone.amazon.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ping")
public class TestController {
	
	@PreAuthorize("hasAuthority('admin')")
	@GetMapping("/data")
	public String test() {
	    try {
	        return "Welcome";
	    } catch (Exception e){
	        throw new RuntimeException(e);
	    }
	} 
}
