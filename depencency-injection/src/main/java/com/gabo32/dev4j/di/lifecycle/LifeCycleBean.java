package com.gabo32.dev4j.di.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype") pre destroy no se ejecuta para beans prototype
@Lazy(false)//si el bean es lazy no se inicializa hasta que se inyecte
public class LifeCycleBean implements BeanNameAware, InitializingBean, DisposableBean {

	private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);

	/**
	 * Durante la construccion del bean
	 * 
	 */
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
	 * anste de que el bean sea destruido no se ejecutan para beans prototype Solo
	 * se ejecutan con una terminacion normal
	 */
	@PreDestroy
	public void destroyBean() {
		log.info("Pre destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("After properties set method");
	}

	@Override
	public void destroy() throws Exception {
		log.info("Destroy method");
	}
}
