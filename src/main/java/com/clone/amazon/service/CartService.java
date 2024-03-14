package com.clone.amazon.service;

import java.util.List;

import com.clone.amazon.collections.Cart;
import com.clone.amazon.exceptions.amazonException;

public interface CartService {
	
	Cart saveCartItems(String productId, String userId);
	String deleteCartItem(String productId,String userId);
	List<Cart> getAllCart(String userId) throws amazonException;
	String clearCart(String userId);
	Cart upDateCart(String productId);
	Cart upDate(String productId);

}
