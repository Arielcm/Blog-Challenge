package com.java_blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.java_blog.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	PostService postservice;
	
	@GetMapping("/")
	public String index() {
		return "Posts/index";
	}

}
