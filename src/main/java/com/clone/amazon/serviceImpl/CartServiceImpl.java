package com.clone.amazon.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.amazon.collections.Cart;
import com.clone.amazon.collections.Product;
import com.clone.amazon.collections.User;
import com.clone.amazon.repositories.CartRepository;
import com.clone.amazon.repositories.ProductRepository;
import com.clone.amazon.repositories.UserRepository;
import com.clone.amazon.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Cart saveCartItems(String productId, String userId) {
	    User existingUser = userRepository.findById(userId).orElse(null);
	    Product product = productRepository.findById(productId).orElse(null);

	    if (existingUser == null || product == null) {
	        // Handle scenario where user or product is not found
	        return null;
	    }

	    Cart cart = new Cart();
	    cart.setId(product.getId());
	    cart.setTitle(product.getTitle());
	    cart.setSlug(product.getSlug());
	    cart.setDescription(product.getDescription());
	    cart.setPrice(product.getPrice());
	    cart.setCategory(product.getCategory());
	    cart.setBrand(product.getBrand());
	    cart.setDetails(product.getDetails());
	    cart.setTags(product.getTags());
	    cart.setQuantity(product.getQuantity());
	    cart.setSold(product.getSold());
	    cart.setImages(product.getImages());
	    cart.setColor(product.getColor());
	    cart.setSeller(product.getSeller());
	    cart.setRatings(product.getRatings());
	    cart.setTotalRating(product.getTotalRating());
	    cart.setCreatedAt(product.getCreatedAt());
	    cart.setUpdatedAt(product.getUpdatedAt());
	    cart.setCartQuantity(1);

	    Cart addedCart = cartRepository.save(cart);

	    List<Cart> userCart = existingUser.getCart();
	    if (userCart != null) {
	    	userCart.add(addedCart);
	    }else {
	    	userCart = new ArrayList<>();
	    	userCart.add(addedCart);
	    }
	    existingUser.setCart(userCart);
	    userRepository.save(existingUser);
	    return addedCart;
	}


	@Override
	public String deleteCartItem(String productId, String userId) {
	    Cart cart = cartRepository.findById(productId).orElse(null);

	    if (cart != null) {
	        // Find the user by userId
	        User existingUser = userRepository.findById(userId).orElse(null);

	        if (existingUser != null) {
	            // Get the existing cart of the user
	            List<Cart> existingCart = existingUser.getCart();

	            // Remove the specific item from the cart
	            if (existingCart.remove(cart)) {
	                // Update the user's cart
	                existingUser.setCart(existingCart);

	                // Save the updated user entity back to the database
	                userRepository.save(existingUser);
	                cartRepository.delete(cart);

	                return "success";
	            }
	        }
	    }
	    return "error";
	}

	@Override
	public List<Cart> getAllCart(String userId) {
		User user = userRepository.findById(userId).get();
		return user.getCart();
	}

	@Override
	public String clearCart(String userId) {
	    User existingUser = userRepository.findById(userId).orElse(null);
	    if (existingUser == null) {
	        return "User not found";
	    }
	    List<Cart> allCart = existingUser.getCart();
	    for (Cart cart : allCart) {
	        cartRepository.deleteById(cart.getCartId()); 
	    }
	    allCart.clear();
	    existingUser.setCart(allCart);
	    userRepository.save(existingUser);
	    return "Carts cleared successfully";
	}

	@Override
	public Cart upDateCart(String productId) {
		Cart cart = cartRepository.findById(productId).get();
		long newQyantity = cart.getCartQuantity()-1;
		cart.setCartQuantity(newQyantity);
		return cartRepository.save(cart);
	}

	@Override
	public Cart upDate(String productId) {
		Cart cart = cartRepository.findById(productId).get();
		long newQyantity = cart.getCartQuantity()+1;
		cart.setCartQuantity(newQyantity);
		return cartRepository.save(cart);
	}

		
}
