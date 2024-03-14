package com.clone.amazon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clone.amazon.collections.Blog;

@Repository
public interface BlogRepository extends MongoRepository<Blog, String>{

}
