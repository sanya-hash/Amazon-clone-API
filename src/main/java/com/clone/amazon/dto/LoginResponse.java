package com.clone.amazon.dto;

import lombok.Data;

@Data
public class LoginResponse {
	
	private String message;
	private boolean success;
	private UserDto user;
	
	public LoginResponse(String message, boolean success, UserDto user) {
		super();
		this.message = message;
		this.success = success;
		this.user = user;
	}

}
