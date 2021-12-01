package com.gabo32.dev4j.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.gabo32.dev4j.users.entities.User;
import com.gabo32.dev4j.users.repositories.UserRepository;
import com.github.javafaker.Faker;

@SpringBootApplication
@ComponentScan
public class UsersAppApplication implements ApplicationRunner{

	@Autowired
	private Faker faker;
	
	@Autowired
	private UserRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(UsersAppApplication.class, args);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		for(int i=0; i<100000; i++) {
			User user = new User();
			user.setUsername(faker.name().username());
			user.setPassword(faker.dragonBall().character());
			user.setProfile(null);
			repository.save(user);
		}
	}

}
