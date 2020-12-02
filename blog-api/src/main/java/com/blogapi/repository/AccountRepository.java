package com.blogapi.repository;

import com.blogapi.repository.dao.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "admin", path = "admin")
public interface AccountRepository extends MongoRepository<Account, String> {
    List<Account> findByUser(@Param("name") String name);
}
