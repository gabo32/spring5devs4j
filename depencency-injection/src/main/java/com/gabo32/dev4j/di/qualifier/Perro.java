package com.gabo32.dev4j.di.qualifier;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Perro extends Animal{

	public Perro(@Value("1") Integer edad,@Value("Rocky") String nombre) {
		super(edad, nombre);
	}

}
