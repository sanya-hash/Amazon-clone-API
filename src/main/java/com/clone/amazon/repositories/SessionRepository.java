package com.clone.amazon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clone.amazon.collections.Session;

@Repository
public interface SessionRepository extends MongoRepository<Session, String>{

}
