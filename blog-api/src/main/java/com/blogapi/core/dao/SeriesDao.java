package com.blogapi.core.dao;

import com.blogapi.core.entity.Series;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesDao extends MongoRepository<Series, String> {
}
