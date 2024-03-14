package com.clone.amazon.collections;

import lombok.Data;

@Data
public class OrderItem {

    private Product product;

    private int quantity;

    private String color;
    
    private String orderStatus;

    public OrderItem() {

    }
}
