package com.blogapi.core.dao;

import com.blogapi.core.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends MongoRepository<Account, String> {
}
