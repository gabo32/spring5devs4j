package com.gabo32.dev4j.di.qualifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component("pajarito")
@Component
@Primary// este es el objeto principal
public class Pajaro extends Animal implements Volador {

	private static final Logger log = LoggerFactory.getLogger(Pajaro.class);

	public Pajaro(@Value("5") Integer edad, @Value("pajaro loco") String nombre) {
		super(edad, nombre);
	}

	@Override
	public void volar() {
		log.info("Soy un pajaro y estoy volando");

	}

}
