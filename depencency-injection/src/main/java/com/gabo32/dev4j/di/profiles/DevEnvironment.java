package com.gabo32.dev4j.di.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(value= {"dev","default"})
public class DevEnvironment implements EnvironmentService{

	@Override
	public String getEnvironment() {
		return "Dev";
	}

}
