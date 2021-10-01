package com.gabo32.dev4j.di.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutExample {

	//@Pointcut("execution(* com.gabo32.dev4j.di.aop.TargetObject.*(..))")
	//@Pointcut("within(com.gabo32.dev4j.di.aop.*)")//todos los de este paquete aop
	@Pointcut("@annotation(Devs4jAnnotation)")//todos los que tengan la anotacion
	public void targetObjectMethods() {
		
	}
}
