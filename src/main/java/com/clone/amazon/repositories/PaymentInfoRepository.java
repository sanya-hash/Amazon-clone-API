package com.clone.amazon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clone.amazon.collections.PaymentInfo;

@Repository
public interface PaymentInfoRepository extends MongoRepository<PaymentInfo, String>{

}
