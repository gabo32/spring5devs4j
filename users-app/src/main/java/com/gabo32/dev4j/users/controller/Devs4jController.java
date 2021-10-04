package com.gabo32.dev4j.users.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Devs4jController {
	
	@GetMapping
	public String helloWorld() {
		return "Hello World";
	}

}
