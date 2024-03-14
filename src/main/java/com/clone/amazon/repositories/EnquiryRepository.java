package com.clone.amazon.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clone.amazon.collections.Enquiry;

@Repository
public interface EnquiryRepository extends MongoRepository<Enquiry, String>{

}
