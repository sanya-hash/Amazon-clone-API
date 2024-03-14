package com.clone.amazon.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.amazon.collections.Order;
import com.clone.amazon.collections.OrderItem;
import com.clone.amazon.collections.Product;
import com.clone.amazon.collections.User;
import com.clone.amazon.dto.OrderDto;
import com.clone.amazon.dto.OrderItemDto;
import com.clone.amazon.repositories.OrderRepository;
import com.clone.amazon.repositories.UserRepository;
import com.clone.amazon.service.OrderService;
import com.clone.amazon.service.ProductService;
import com.clone.amazon.service.UserService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;

	@Override
	public Order createOrder(OrderDto orderDto, String userId) {
		
		Order order = new Order();
		List<OrderItem> orderItems = new ArrayList<>();
		
		List<OrderItemDto> orderItemDtos = orderDto.getOrderItemsDto();
		for(OrderItemDto orderItemDto : orderItemDtos) {
			OrderItem orderItem = new OrderItem();
			Product product = productService.getProduct(orderItemDto.getProduct());
			orderItem.setProduct(product);
			orderItem.setColor(orderItemDto.getColor());
			orderItem.setQuantity(orderItemDto.getQuantity());
			orderItem.setOrderStatus("order placed");
		    orderItems.add(orderItem);
		}
		order.setOrderItems(orderItems);
		order.setShippingInfo(orderDto.getShippingInfo());
		order.setTotalPrice(orderDto.getTotalPrice());
		
		
		Order addedOrder = orderRepository.insert(order);
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		List<Order> existedOrder = user.getOrders();
		
		if(existedOrder!=null) {
			existedOrder.add(addedOrder);
		}else {
			existedOrder = new ArrayList<>();
			existedOrder.add(addedOrder);
		}
		user.setOrders(existedOrder);
		userRepository.save(user);
		return addedOrder;
	}

	@Override
	public List<Order> findOrder(String userId) {
		return userService.getOrders(userId);
	}
	
	@Override
	public List<Order> getTopTransactions(){
		return orderRepository.findAll();
	}
	
	@Override
	 public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}

}
