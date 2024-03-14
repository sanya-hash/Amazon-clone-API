package com.clone.amazon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clone.amazon.collections.ProdCategory;

@Repository
public interface ProductCategoryRepository  extends MongoRepository<ProdCategory, String>{

}