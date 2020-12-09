package com.blogapi.core.dao;

import com.blogapi.core.entity.Sign;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignDao extends MongoRepository<Sign, String> {
}
