package com.clone.amazon.service;

import java.util.List;

import com.clone.amazon.collections.Order;
import com.clone.amazon.collections.Product;
import com.clone.amazon.collections.User;
import com.clone.amazon.model.UserModel;

public interface UserService {

	User createUser(UserModel userModel);
	List<Product> getWishListItem(String id);
	List<Order> getOrders(String userId);
	String addWishlist(String prodId, String userId);
	String removeFromWishLiist(String prodId, String userId);
	User findUser(String username);
    void forgotPassword(String email);
    public User resetPassword(String token, String newPassword);
	public String deleteUser(String id);
  
}
