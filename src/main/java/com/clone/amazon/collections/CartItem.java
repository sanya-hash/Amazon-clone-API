package com.clone.amazon.collections;

import lombok.Data;

@Data
public class CartItem {
	
    private Product product;
    private long cartQuantity;
    
}
