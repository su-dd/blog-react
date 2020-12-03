package com.blogapi.dao;

import com.blogapi.dao.po.Series;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "series", path = "series")
public interface SeriesRepository extends MongoRepository<Series, String> {
}
