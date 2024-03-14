package com.clone.amazon.service;

import java.util.List;

import com.clone.amazon.collections.Blog;
import com.clone.amazon.exceptions.amazonException;

public interface BlogService {
	
	Blog saveBlog(Blog blog);
	Blog getBlog(String id) throws amazonException;
	List<Blog> getAllBlogs();

}
