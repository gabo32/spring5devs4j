package com.gabo32.dev4j.di.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LifeCycleBean implements BeanNameAware{
		
	private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);

	@Override
	public void setBeanName(String name) {
		log.info("Bean name {} aware", name);
	}

	/**
	 * Se ejecuta despues de la inyecion de dependencias
	 */
	@PostConstruct
	public void init() {
		log.info("Post construct");
	}
	
	/**
	 * anste de que el bean sea destruido
	 * no se ejecutan para beans prototype
	 * Solo se ejecutan con una terminacion normal
	 */
	@PreDestroy
	public void destroy() {
		log.info("Pre destroy");
	}
}
