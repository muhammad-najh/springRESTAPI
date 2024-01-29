package com.skysoft.restapi.restapiproject.socialmedia;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.parser.Entity;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.skysoft.restapi.restapiproject.jpa.PostRepository;
import com.skysoft.restapi.restapiproject.jpa.UserRepository;
import com.skysoft.restapi.restapiproject.socialmedia.exception.UserNotFoundException;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserJpaResource {

	PostRepository postRepository;
	UserRepository userRepository;
	public UserJpaResource(PostRepository postRepository,UserRepository userRepository) {
		this.postRepository = postRepository;
		this.userRepository=userRepository;
	}
	
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> getUser(@PathVariable int id) {
		Optional<User> user= userRepository.findById(id);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException("id"+id);
		}
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));

		return entityModel;
	}
	
	@PostMapping("/jpa/add-user")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		userRepository.save(user);
	
	URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(user.getId())
			.toUri();   

        return ResponseEntity.created(location).build();


	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostsForUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isEmpty())
			throw new UserNotFoundException("id:"+id);
		
		return user.get().getPosts();

	}

	@PostMapping("/jpa/user/{id}/posts")
	public ResponseEntity<Post> creatUserPost(@PathVariable int id,@RequestBody Post post) {
		Optional<User> user=userRepository.findById(id);
		if(user.isEmpty()){
			throw new UserNotFoundException("id"+id);
		}

		post.setUser(user.get());
		Post savePost=postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savePost.getId())
		.toUri();   

	return ResponseEntity.created(location).build();

	}
	
	
	
	
}
