package com.blogapi.dao;

import com.blogapi.dao.po.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "comment", path = "comment")
public interface CommentRepository extends MongoRepository<Comment, String> {
}
