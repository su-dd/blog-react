package com.blogapi.dao;

import com.blogapi.dao.po.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "article", path = "article")
public interface ArticleRepository extends MongoRepository<Article, String> {
}
