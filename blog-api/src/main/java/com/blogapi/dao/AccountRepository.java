package com.blogapi.dao;

import com.blogapi.dao.po.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
}
