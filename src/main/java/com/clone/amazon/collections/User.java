package com.clone.amazon.collections;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "users")
@Data
public class User {
	
    @Id
    private String id;

    private String firstname;

    private String lastname;

    private String username;

    private String mobile;

    private String password;

    private String profile;

    @DBRef
    private Set<UserRole> roles = new HashSet<>();

    private boolean isBlocked;

    @DBRef
    private List<Cart> cart;

    private String address;

    @DBRef
    private List<Product> wishlist;
    
    @DBRef
    private List<Order> orders;

    private String refreshToken;

    private String otp;

    private Date passwordChangedAt;

    private String passwordResetToken;

    private Date passwordResetExpires;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    
    public User() {
    	this.createdAt = LocalDateTime.now();
    	this.updatedAt = LocalDateTime.now();
    }
}
