package com.blogapi.core.dao;

import com.blogapi.core.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends MongoRepository<User, String> {
    User findUserByUserName(String userName);
}
