package com.gabo32.dev4j.users;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class UsersAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersAppApplication.class, args);
		//HashMap<K, V>
	}

}
