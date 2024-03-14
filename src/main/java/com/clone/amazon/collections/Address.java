package com.clone.amazon.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "address")
@Data
public class Address {
	
	@Id
    private String id;
    private String name;
    private String mobile;
    private String address;
    private String state;
    private String zipcode;

}
