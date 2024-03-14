package com.clone.amazon.service;

import java.util.List;

import com.clone.amazon.collections.Order;
import com.clone.amazon.dto.OrderDto;

public interface OrderService {
	
	Order createOrder(OrderDto orderDto, String userId);
	List<Order> findOrder(String userId);
	 List<Order> getTopTransactions();
	 List<Order> getAllOrders();
}
