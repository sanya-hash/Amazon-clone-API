package com.clone.amazon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clone.amazon.collections.Color;

@Repository
public interface ColorRepository extends MongoRepository<Color, String>{

}
