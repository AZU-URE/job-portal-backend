package com.azuure.JobListing.respository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.azuure.JobListing.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
