package com.gabo32.dev4j.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabo32.dev4j.users.entities.Address;
import com.gabo32.dev4j.users.services.AddressService;

@RestController
@RequestMapping("/users/{userId}/profiles/{profileId}/addresses")
public class AddressController {
	
	@Autowired
	private AddressService addressService;

	@GetMapping
	public ResponseEntity<List<Address>> findAddressesByProfileAndUserId(
			@PathVariable("userId") Integer userId,
			@PathVariable("profileId") Integer profileId){
		return new ResponseEntity<>(addressService.findAddressesByProfileAndUserId(userId, profileId), HttpStatus.OK);	
	}
	
	@PostMapping
	public ResponseEntity<Address> create(
			@PathVariable("userId") Integer userId,
			@PathVariable("profileId") Integer profileId,
			@RequestBody Address address){
		return new ResponseEntity<>(addressService.createAddress(userId, profileId, address), HttpStatus.CREATED);
	}
}
