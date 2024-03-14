package com.clone.amazon.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.clone.amazon.utils.IDgenerator;

@Data
public class ShippingInfo {
    
    private String name;

    private String address;

    private String state;

    private int pincode;

    private String mobile;
    
    public ShippingInfo() {
    	
    }
}
