package com.clone.amazon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clone.amazon.collections.Brand;

@Repository 
public interface BrandRepository extends MongoRepository<Brand, String>{

}
