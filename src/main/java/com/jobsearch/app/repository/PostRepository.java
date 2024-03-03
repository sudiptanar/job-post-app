package com.jobsearch.app.repository;

import com.jobsearch.app.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
