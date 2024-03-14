package com.clone.amazon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clone.amazon.collections.Address;

@Repository
public interface AddressRepository extends MongoRepository<Address, String>{

}
