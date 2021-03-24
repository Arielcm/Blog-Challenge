package com.java_blog.service;

import com.java_blog.entity.Post;

public interface PostService {

public Iterable<Post> getAllPost();
	
	public Post createPost(Post postForm) throws Exception;
	
	public Post getPostById(Long id) throws Exception;
	
	public void deletePost(Long id) throws Exception;
	
	public Post updatePost(Post post) throws Exception;
}
