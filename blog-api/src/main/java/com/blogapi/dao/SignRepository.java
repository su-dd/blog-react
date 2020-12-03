package com.blogapi.dao;

import com.blogapi.dao.po.Sign;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface SignRepository extends MongoRepository<Sign, String> {
}
