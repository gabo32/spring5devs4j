package com.gabo32.dev4j.di.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	
	private static final Logger log = LoggerFactory.getLogger(MyAspect.class);

	//indicamos que intervenga cualquier metodo de TargeObject
	@Before("execution(* com.gabo32.dev4j.di.aop.TargetObject.*(..))")
	public void before() {
		log.info("Before advice");
	}
}
