package com.clone.amazon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clone.amazon.collections.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>{

}
