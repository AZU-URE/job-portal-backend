package com.azuure.JobListing.respository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.azuure.JobListing.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class SearchPost implements SearchPostRepository{
	@Autowired
	private MongoClient mongoClient ;
	@Autowired
	private MongoConverter conv;
	
	public List<Post> searchPost(String text) {
		
		List<Post> posts = new ArrayList<Post>();
		
		MongoDatabase database = mongoClient.getDatabase("JobListing");
		MongoCollection<Document> collection = database.getCollection("Post");
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
		    new Document("index", "jobListing-post")
		            .append("text", 
		    new Document("query", "Javascript")
		                .append("path", Arrays.asList("title", "desc", "exp", "tech")))), 
		    new Document("$sort", 
		    new Document("exp", 1L)), 
		    new Document("$limit", 5L)));
		System.out.println(result);
		result.forEach(doc->posts.add(conv.read(Post.class, doc)));
		
		return posts;
	}
	

}
