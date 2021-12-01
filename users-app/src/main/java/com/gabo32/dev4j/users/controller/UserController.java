package com.gabo32.dev4j.users.controller;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gabo32.dev4j.users.entities.User;
import com.gabo32.dev4j.users.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<Page<User>> getUsers(
			@RequestParam(required=false,name="page", defaultValue="0")int page,
			@RequestParam(required=false,name="size", defaultValue="1000") int size){
		return new ResponseEntity<>(service.getUsers(page, size), HttpStatus.OK);
	}
	
	@GetMapping("/usernames")
	public ResponseEntity<Page<String>> getUsernames(
			@RequestParam(required=false,name="page", defaultValue="0")int page,
			@RequestParam(required=false,name="size", defaultValue="10") int size){
		return new ResponseEntity<>(service.getUsernames(page, size), HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable (value="userId") Integer userId){
		return new ResponseEntity<>(service.getUserById(userId), HttpStatus.OK);
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable(value="username") String username){
		return new ResponseEntity<>(service.getuserByUsername(username), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> authenticate(@RequestBody User user){
		return new ResponseEntity<>(service.getuserByUsernameAndPassword(user.getUsername(), user.getPassword()), HttpStatus.OK);
	}
}
