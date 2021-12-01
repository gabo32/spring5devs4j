package com.gabo32.dev4j.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
				.select().apis(RequestHandlerSelectors.basePackage("com.gabo32.dev4j.users.controller"))
				//.paths(PathSelectors.ant("/users/*")).build();//solo un path
				.paths(PathSelectors.any())
				.build()
				.useDefaultResponseMessages(false);
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("Devs4j api")
				.version("1.0")
				.license("Apache 2.0")
				.contact(new Contact("Gabo32", "http://gabo32.com", "j.gabriel.b@live.com.mx"))
				.build();
	}
}
