package com.clone.amazon.collections;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "cart")
public class Cart {

	@Id
	private String cartId;
    private String id;
    private String title;
    private String slug;
    private String description;
    private double price;
    @DBRef
    private ProdCategory category;
    @DBRef
    private Brand brand;
    private String details;
    private List<String> tags;
    private int quantity;
    private int sold;
    private List<Image> images;
    @DBRef
    private List<Color> color;
    @DBRef
    private User seller;
    @DBRef
    private List<Rating> ratings;
    private double totalRating;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private long cartQuantity;
	
}
