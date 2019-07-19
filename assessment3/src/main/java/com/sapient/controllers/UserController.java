package com.sapient.controllers;
import com.sapient.model.*;
import com.sapient.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping(value="/", produces= {APPLICATION_JSON_VALUE , APPLICATION_XML_VALUE})
	 //@ApiOperation(value = "Fetch all employees", notes = "API to fetch all the employees")
	public List<User> listAllUsers() {
		List<User> userList = userService.listAll();
		return userList;
	}

	@GetMapping(value="/{id}", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public User findById(@PathVariable("id") long id)
	{
		System.out.println("PRODUCT ID : " + id);
	    User user =userService.findById(id);
		return user;
	}

	@PostMapping(value="/save", consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	 @ResponseStatus(HttpStatus.CREATED)
	public void saveProduct(@Valid @RequestBody User user) {
		
		userService.insert(user);
	        System.out.println("Came inside the post method of user");
		
	}
	@GetMapping(value="/user/{id}/posts", produces= {APPLICATION_JSON_VALUE , APPLICATION_XML_VALUE})
	public List<Post> findPostById(@ApiParam(value="FIND BY ID")@PathVariable("id") long id)
	{
		return userService.findPostById(id);
	} 
	@GetMapping(value="/user/{id}/posts/{pid}", produces= {APPLICATION_JSON_VALUE ,APPLICATION_XML_VALUE})
	public Post findPostById(@ApiParam(value="FIND BY ID")@PathVariable("id") long id,@ApiParam(value="FIND BY PID")@PathVariable("pid") long pid)
	{
		return userService.findPostByIdById(id,pid);
	} 

	@PutMapping(value="/{id}", consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public void updateProduct(@PathVariable long id, @RequestBody User user) {
		userService.update(id,user);
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteProduct(@PathVariable long  id) {
		userService.delete(id);
	}
	@PostMapping(value="/user/{id}/posts", consumes= {APPLICATION_JSON_VALUE , APPLICATION_XML_VALUE})
	public void putPostById(@ApiParam(value="FIND BY ID")@PathVariable("id") long id,@Valid @RequestBody Post post )
	{
		userService.putPostById(id,post);
	} 
}