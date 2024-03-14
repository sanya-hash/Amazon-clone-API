package com.clone.amazon.dto;

import java.util.List;

import com.clone.amazon.collections.ShippingInfo;

import lombok.Data;

@Data
public class OrderDto {
	
	private ShippingInfo shippingInfo;

    private List<OrderItemDto> orderItemsDto;
    
    private double totalPrice;

}
