package com.clone.amazon.dto;

import lombok.Data;

@Data
public class OrderItemDto {
	
	private String product;

    private int quantity;

    private String color;
    
    private String orderStatus;

}
