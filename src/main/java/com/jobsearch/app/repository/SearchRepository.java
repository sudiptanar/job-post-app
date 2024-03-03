package com.jobsearch.app.repository;

import com.jobsearch.app.model.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String text);
}
