package com.azuure.JobListing.controller;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.azuure.JobListing.model.Post;
import com.azuure.JobListing.respository.PostRepository;
import com.azuure.JobListing.respository.SearchPost;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
@RequestMapping("api")
public class PostController {
	
	@Autowired
	private PostRepository repo;
	@Autowired
	private SearchPost searchRepo;
	
	@Hidden
	@RequestMapping("/swagger/*")
	public RedirectView redirectRequests() {
		return new RedirectView("/swagger/swagger-ui/index.html");
	}
	
	@GetMapping("posts")
	public List<Post> getAllPosts(){
		return repo.findAll();
	}
	
	@PostMapping("post")
	public Post addPost(@RequestBody Post post) {
		return repo.save(post);
	}
	
	@PostMapping("post/{searchText}")
	public List<Post> search(@PathVariable String searchText){
		return searchRepo.searchPost(searchText);
	}
	
	
}
