package com.clone.amazon.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.clone.amazon.collections.Cart;
import com.clone.amazon.collections.Product;
import com.clone.amazon.collections.User;
import com.clone.amazon.collections.UserRole;

import lombok.Data;

@Data
public class UserDto {
	
	private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String mobile;
    private String password;
    private Set<UserRole> roles = new HashSet<>();
    private boolean isBlocked;
    private String refreshToken;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Cart> cart;
    private List<Product> wishlist;
    
    public static UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

}
