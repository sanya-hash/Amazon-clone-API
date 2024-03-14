package com.clone.amazon.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clone.amazon.collections.User;
import com.clone.amazon.collections.UserRole;


@Repository
public interface UserRepository extends MongoRepository<User, String>{

	User findByUsername(String email);
		
	 User findByPasswordResetToken(String token);
	 
	    List<User> findByRoles_Id(String roleId); 

	 

}
