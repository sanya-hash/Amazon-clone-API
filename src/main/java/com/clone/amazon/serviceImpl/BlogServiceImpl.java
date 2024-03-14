package com.clone.amazon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.amazon.collections.Blog;
import com.clone.amazon.exceptions.BlogException;
import com.clone.amazon.exceptions.amazonException;
import com.clone.amazon.repositories.BlogRepository;
import com.clone.amazon.service.BlogService;
import com.clone.amazon.utils.ErrorBank;
import com.clone.amazon.utils.Identifier;

@Service
public class BlogServiceImpl implements BlogService{

	@Autowired
	private BlogRepository blogRepository;
	
	@Override
	public Blog saveBlog(Blog blog) {
		return blogRepository.save(blog);
	}

	@Override
	public Blog getBlog(String id) throws amazonException{
		// TODO Auto-generated method stub
		Blog b= new Blog();

		try {
			if(id!=null)
		 b=blogRepository.findById(id).get();
		}catch(Exception e) {
			e.printStackTrace();
			throw new BlogException(Identifier.BLOG, ErrorBank.ERROR_BLOG_DOESNOT_EXIST);
		}
		return b;
	}
	
	@Override
	public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

}
