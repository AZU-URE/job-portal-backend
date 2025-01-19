package com.azuure.JobListing.respository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.azuure.JobListing.model.Post;

@Repository
public interface SearchPostRepository {
	public List<Post> searchPost(String text);
}
