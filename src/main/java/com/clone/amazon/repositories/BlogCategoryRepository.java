package com.clone.amazon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clone.amazon.collections.BlogCategory;

@Repository
public interface BlogCategoryRepository extends MongoRepository<BlogCategory, String>{

}
