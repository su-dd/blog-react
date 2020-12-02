package com.blogapi.dao;

import com.blogapi.dao.po.Account;
import com.blogapi.dao.po.Bloger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "bloger", path = "bloger")
public interface BlogerRepository extends MongoRepository<Bloger, String> {
}