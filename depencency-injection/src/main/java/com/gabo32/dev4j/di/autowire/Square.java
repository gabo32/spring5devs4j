package com.gabo32.dev4j.di.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Square implements Figure{

	//@Value("2.5")
	@Value("${square.side:2}")
	private double side;
	
	@Override
	public double calculateArea() {
		return side*side;
	}

}
