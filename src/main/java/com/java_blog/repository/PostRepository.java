package com.java_blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java_blog.entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>{

}
