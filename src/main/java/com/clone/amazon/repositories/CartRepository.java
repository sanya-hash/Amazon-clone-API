package com.clone.amazon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clone.amazon.collections.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, String>{

}
