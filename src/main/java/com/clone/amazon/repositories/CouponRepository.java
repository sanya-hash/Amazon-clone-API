package com.clone.amazon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clone.amazon.collections.Coupon;

@Repository
public interface CouponRepository extends MongoRepository<Coupon, String>{

}
