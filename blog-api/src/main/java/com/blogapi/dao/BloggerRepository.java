package com.blogapi.dao;

import com.blogapi.dao.po.Blogger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloggerRepository extends MongoRepository<Blogger, String> {
}
