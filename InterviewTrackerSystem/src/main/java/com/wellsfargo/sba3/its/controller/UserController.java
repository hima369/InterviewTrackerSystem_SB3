package com.wellsfargo.sba3.its.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.sba3.its.entity.User;
import com.wellsfargo.sba3.its.exception.UserNotFoundException;
import com.wellsfargo.sba3.its.exception.model.ExceptionResponse;
import com.wellsfargo.sba3.its.service.UserService;



@RestController
@RequestMapping("/api")

public class UserController {
	
	@Autowired
	UserService userservice;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = this.userservice.getAll();		
		ResponseEntity<List<User>> response = new ResponseEntity<List<User>>(users,HttpStatus.OK);	
		return response;
		
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		User user = this.userservice.getById(id);
		if(user==null) {
			throw new UserNotFoundException("user is not found-" + id);
		}		
		ResponseEntity<User> response = new ResponseEntity<User>(user, HttpStatus.OK);
		return null;
			
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User adduser = this.userservice.add(user);
		
		ResponseEntity<User> response = new ResponseEntity<User>(adduser, HttpStatus.OK);		
		return response;
		
	}
	
	@PutMapping("/users")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User updateuser = this.userservice.update(user);
		ResponseEntity<User> response = new ResponseEntity<User>(updateuser, HttpStatus.OK);
		return response;
		
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
		User user = this.userservice.delete(id);
		
		if(user == null) {
			throw new UserNotFoundException("user is not found with id " + id);
		}
		ResponseEntity<User> response = new ResponseEntity<User>(user, HttpStatus.OK);
		return response;
		
	}
	
	//Exception Handler
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse>handler(UserNotFoundException ex){
		
		ExceptionResponse exResponse =
				new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse> response = 
				new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.NOT_FOUND);
		
		return response;		
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handler(Exception ex) {
		ExceptionResponse exResponse =
				new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse> response = 
				new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.BAD_REQUEST);
		return response;
	}
	
}
