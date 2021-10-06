package com.gabo32.dev4j.users.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gabo32.dev4j.users.models.User;
import com.github.javafaker.Faker;

@Service
public class UserService {

	@Autowired
	private Faker faker;

	private List<User> users = new ArrayList<>();

	@PostConstruct
	public void init() {
		for(int i=0; i< 100; i++) {
			users.add(new User(faker.funnyName().name(), faker.name().username(), faker.dragonBall().character()));
		}
	}
	
	public List<User> getUsers(String startsWith){
		if( startsWith != null) {
			return users.stream().filter(u->u.getUsername().startsWith(startsWith)).collect(Collectors.toList());
		}
		return users;
	}
	
	public User getUserByUserName(String username) {
		return users.stream().filter(u->u.getUsername().equals(username)).findAny()
			.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, 
					String.format("User %s not found",  username)));
	}
	
	public User createUser(User user) {
		if(users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()))) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("User %s already exists", user.getUsername()));
		}
		
		users.add(user);
		return user; 
	}
	
	public User updateUser(User user, String username) {
		User userToUpdate= getUserByUserName(username);
		userToUpdate.setNickName(user.getNickName());
		userToUpdate.setPassword(user.getPassword());
		
		return userToUpdate;
	}
	
	
	public void deleteUser(String username) {
		User userToDelete = getUserByUserName(username);
		
		users.remove(userToDelete);
	}
	
}
