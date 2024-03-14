package com.clone.amazon.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private ShippingInfo shippingInfo;

    private List<OrderItem> orderItems;
    
    private double totalPrice;

    private LocalDateTime paidAt;
    
    public Order() {
      this.paidAt = LocalDateTime.now();
    }
}
