package com.blogapi.dao;

import com.blogapi.dao.po.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(collectionResourceRel = "account", path = "account")
public interface AccountRepository extends MongoRepository<Account, String> {


}
