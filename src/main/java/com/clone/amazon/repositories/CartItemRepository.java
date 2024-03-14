package com.clone.amazon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clone.amazon.collections.CartItem;

@Repository
public interface CartItemRepository extends MongoRepository<CartItem, String>{

}
