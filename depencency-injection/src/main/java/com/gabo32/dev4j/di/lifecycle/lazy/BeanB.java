package com.gabo32.dev4j.di.lifecycle.lazy;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy(false)
@Lazy
public class BeanB {

	private static final Logger log = LoggerFactory.getLogger(BeanB.class);

	@Autowired
	private BeanA bean;

	@PostConstruct
	public void init() {
		log.info("init bean b");
	}
}
