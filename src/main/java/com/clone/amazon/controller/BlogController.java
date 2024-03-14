package com.clone.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.amazon.collections.Blog;
import com.clone.amazon.exceptions.amazonException;
import com.clone.amazon.service.BlogService;

@RestController
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@PostMapping("/save")
	public Blog saveBlogData(@RequestBody Blog blog) {
		return blogService.saveBlog(blog);
	}
	
	@GetMapping("/{id}")
	public Blog getBlogata(@PathVariable String id) throws amazonException {
		return blogService.getBlog(id);
	}
	
	@GetMapping("/")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        try {
            List<Blog> blogs = blogService.getAllBlogs();
            return ResponseEntity.ok(blogs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
