package com.blogapi.core.dao;

import com.blogapi.core.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao extends MongoRepository<Comment, String> {
}
