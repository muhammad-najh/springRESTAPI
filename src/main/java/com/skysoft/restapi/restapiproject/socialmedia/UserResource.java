package com.skysoft.restapi.restapiproject.socialmedia;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.skysoft.restapi.restapiproject.socialmedia.exception.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}
	
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		User user= service.findUserByID(id);
		
		if(user==null) {
			throw new UserNotFoundException("id"+id);
		}
		
		return user;
	}
	
	@PostMapping("/add-user")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
	service.addUser(user);
	
	URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(user.getId())
			.toUri();   

return ResponseEntity.created(location).build();


	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteByID(id);
	}
	
	
}
