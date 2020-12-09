package com.blogapi.core.dao;

import com.blogapi.core.entity.Blogger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloggerDao extends MongoRepository<Blogger, String> {
}
