package com.clone.amazon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clone.amazon.collections.UserRole;

@Repository
public interface UserRoleRepository extends MongoRepository<UserRole, String>{

}
