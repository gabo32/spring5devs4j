package com.gabo32.dev4j.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabo32.dev4j.users.entities.Profile;
import com.gabo32.dev4j.users.services.ProfileService;

@RestController
@RequestMapping("/users/{userId}/profiles")//la existencia de perfil depende del usuario
public class ProfileController {

	@Autowired
	private ProfileService service;
	
	@GetMapping("/{profileId}")
	public ResponseEntity<Profile> getById(@PathVariable("userId") Integer userId,@PathVariable("profileId") Integer profileId){
		return new ResponseEntity<>(service.getByUserIdAndProfileId(userId, profileId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Profile> create(@PathVariable("userId") Integer userId, @RequestBody Profile profile){
		return new ResponseEntity<>(service.create(userId, profile), HttpStatus.CREATED);
	}
}
