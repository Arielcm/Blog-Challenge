package com.java_blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_blog.entity.Post;
import com.java_blog.repository.PostRepository;

@Service
public class PostServiceImp implements PostService{

	@Autowired
	PostRepository postrepo;
	
	@Override
	public Iterable<Post> getAllPost() {
		return postrepo.findAll();
	}

	@Override
	public Post createPost(Post post) throws Exception {
		post = postrepo.save(post);
		return post;
	}

	@Override
	public Post getPostById(Long id) throws Exception {
		return postrepo.findById(id).orElseThrow(() -> new Exception("El Post Solicitado No Existe!"));
	}

	@Override
	public void deletePost(Long id) throws Exception {
		Post post = postrepo.findById(id).orElseThrow(() -> new Exception("No se puede Eliminar el Post - "+this.getClass().getName()));
		postrepo.delete(post);
		
	}

	@Override
	public Post updatePost(Post frompost) throws Exception {
		Post topost = getPostById(frompost.getId());
		mapPost(frompost, topost);
		return postrepo.save(topost);
	}

	protected void mapPost(Post from, Post to) {
		to.setTitulo(from.getTitulo());
		to.setContenido(from.getContenido());
		to.setImagen(from.getImagen());
		to.setCategoria(from.getCategoria());
		to.setFecha(from.getFecha());
		
	}

}
