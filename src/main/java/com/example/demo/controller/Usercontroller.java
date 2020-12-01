package com.example.demo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class Usercontroller {

	private   UserService userService;
	
	@Autowired
	public Usercontroller(UserService service)
	{
		this.userService=service;
	}
	
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int userId)
	{
		return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
	}
}
