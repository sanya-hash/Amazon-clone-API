package com.clone.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clone.amazon.collections.Cart;
import com.clone.amazon.exceptions.amazonException;
import com.clone.amazon.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/add")
	public Cart addToCart(@RequestParam String productId, @RequestParam String userId) {
		return cartService.saveCartItems(productId, userId);
	}

	@DeleteMapping("/remove")
	public String deleteCart(@RequestParam String productId, @RequestParam String userId) {
		return cartService.deleteCartItem(productId, userId);
	}

	@GetMapping("/get")
	public List<Cart> getCart(@RequestParam(required = false) String userId) throws amazonException {
		return cartService.getAllCart(userId);
	}

	@DeleteMapping("/clear/{userId}")
	public String clearCart(@PathVariable String userId) {
		return cartService.clearCart(userId);
	}

	@PutMapping("/decrease/{productId}")
	public Cart decreaseCart(@PathVariable String productId) {
		return cartService.upDateCart(productId);
	}

	@PutMapping("/increase/{productId}")
	public Cart increaseCart(@PathVariable String productId) {
		return cartService.upDate(productId);
	}

}
