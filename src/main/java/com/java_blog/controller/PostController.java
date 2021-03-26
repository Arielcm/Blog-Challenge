package com.java_blog.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.java_blog.entity.Post;
import com.java_blog.repository.PostRepository;
import com.java_blog.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	PostService postservice;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/posts";
	}
	
	//Listar Posts
	@GetMapping("/posts")
	public String GetPosts(Model model) {
		model.addAttribute("PostForm", new Post());
		model.addAttribute("listapost", postservice.getAllPost());
		model.addAttribute("listTab","active");
		return "Posts/index";
	}
	
	//Agregar Post
	@PostMapping("/posts")
	public String CreatePost(@ModelAttribute("PostForm")Post post, ModelMap model) throws Exception {
		if(!post.getImagen().isEmpty()) {
			String ruta = "/home/lenovo/blogimg" ;
			byte[] bytesImg = post.getImagen().getBytes();
			Path RutaAbsoluta = Paths.get(ruta+"//"+post.getImagen());
			Files.write(RutaAbsoluta, bytesImg);
			

		}
		post.setBorrado(false);
		postservice.createPost(post);
		return "redirect:/";
	}
	
	//Obtiene el Post segun id
	@GetMapping("/posts/{id}")
	public String getPostId(Model model,@PathVariable(name="id")Long id) throws Exception {
		Post post = postservice.getPostById(id);
		model.addAttribute("listapost", postservice.getAllPost());
		model.addAttribute("PostForm", post);
		model.addAttribute("formTab","active");//Activa el tab del formulario.
		
		model.addAttribute("editMode",true);
		
		return "Posts/index";
	}
	
	//Editar Post
	@PatchMapping("/posts/{id}")
	public String postEdit(@ModelAttribute("PostForm")Post post, ModelMap model) throws Exception {
		postservice.updatePost(post);
		return "redirect:/";
	}
	
	//Eliminar Post
	@GetMapping("/postsdel/{id}")
	public String deletePost(Model model,@PathVariable(name="id")Long id) {
		try {
			postservice.deletePost(id);
		} catch (Exception e) {
			model.addAttribute("deleteError","The Post could not be deleted.");
		}
		return "redirect:/";
		
	}
	
	//Boton Cancelar del Formulario
	@GetMapping("post/cancel")
	public String cancelEditCurse(ModelMap model) {
		return "redirect:/";
	}
}
