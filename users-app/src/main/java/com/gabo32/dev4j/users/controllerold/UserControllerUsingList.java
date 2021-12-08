package com.gabo32.dev4j.users.controllerold;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gabo32.dev4j.users.models.User;
import com.gabo32.dev4j.users.servicesold.UserServiceUsingList;

@RestController
@RequestMapping("/v1/users")
public class UserControllerUsingList {
	
	@Autowired
	private UserServiceUsingList userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers(@RequestParam(required=false,name="startsWith") String startsWith){
		return new ResponseEntity<> (userService.getUsers(startsWith), HttpStatus.OK);
	}
	
	@GetMapping(value="/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username){
		return new ResponseEntity<>(userService.getUserByUserName(username), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
	} 
	
	@PutMapping(value="/{username}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("username") String username){
		return new ResponseEntity<>(userService.updateUser(user, username), HttpStatus.OK);
	}
	
	@DeleteMapping("/{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable("username") String username){
		userService.deleteUser(username); 
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
