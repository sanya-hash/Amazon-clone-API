package com.clone.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.amazon.collections.Order;
import com.clone.amazon.collections.Product;
import com.clone.amazon.dto.OrderDto;
import com.clone.amazon.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/create/{userId}")
	public Order saveOrder(@RequestBody OrderDto orderDto, @PathVariable String userId) {
		return orderService.createOrder(orderDto,userId);
	}
	
	@GetMapping("/get/{userId}")
	public List<Order> getOrder(@PathVariable String userId){
		return orderService.findOrder(userId);
	}
	
	@PreAuthorize("hasAuthority('admin')")
    @GetMapping("/getorders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

	

}
