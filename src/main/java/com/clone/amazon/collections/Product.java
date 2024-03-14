package com.clone.amazon.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "products")
public class Product {
    
    @Id
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
    public Product() {
    	this.createdAt = LocalDateTime.now();
    	this.updatedAt = LocalDateTime.now();
        
    }
}
