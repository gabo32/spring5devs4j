package com.gabo32.dev4j.di.qualifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Nido {
	private static final Logger log = LoggerFactory.getLogger(Nido.class);

	@Autowired
	//@Qualifier("pajarito")
	private Animal animal;
	
	public void imprimir() {
		log.info("Mi nido tiene al animal {}", animal.getNombre());
	}
		
}
