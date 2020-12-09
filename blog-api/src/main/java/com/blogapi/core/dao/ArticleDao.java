package com.blogapi.core.dao;

import com.blogapi.core.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends MongoRepository<Article, String> {
}
