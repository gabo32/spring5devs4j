package com.gabo32.dev4j.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.gabo32.dev4j.di.aop.TargetObject;
import com.gabo32.dev4j.di.atributo.Coche;
import com.gabo32.dev4j.di.autowire.AreaCalculatorService;
import com.gabo32.dev4j.di.lifecycle.ExplicitBean;
import com.gabo32.dev4j.di.lifecycle.LifeCycleBean;
import com.gabo32.dev4j.di.profiles.EnvironmentService;
import com.gabo32.dev4j.di.qualifier.Animal;
import com.gabo32.dev4j.di.qualifier.Avion;
import com.gabo32.dev4j.di.qualifier.Nido;
import com.gabo32.dev4j.di.qualifier.Pajaro;
import com.gabo32.dev4j.di.qualifier.Perro;
import com.gabo32.dev4j.di.scopes.EjemploScopeService;

//@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class DepencencyInjectionApplication {

	
	private static final Logger log = LoggerFactory.getLogger(DepencencyInjectionApplication.class);

	
	public static void main(String[] args) {
		//Recuperamos el contexto de spring
		ConfigurableApplicationContext contex = SpringApplication.run(DepencencyInjectionApplication.class, args);
		
		/*Coche coche = contex.getBean(Coche.class);
		//System.out.println(coche);
		
		Perro perro = contex.getBean(Perro.class);
		log.info("Objeto perrro {}", perro.getNombre());

		Pajaro pajaro = contex.getBean(Pajaro.class);
		log.info("Objeto pajaro {}", pajaro.getNombre());
		
		Avion avion = contex.getBean(Avion.class);
		avion.volar();
		
		Animal animal = contex.getBean(Animal.class);
		//Animal animal = contex.getBean(" Animal.class);//se indica el nombre de la clase
		log.info("Objeto animal  {}", animal.getNombre());
		
		Nido nido = contex.getBean(Nido.class);
		nido.imprimir();
		
		EnvironmentService environmentService = contex.getBean(EnvironmentService.class);
		log.info("Active environment: {}", environmentService.getEnvironment());
		
		EjemploScopeService ejemploScopeService = contex.getBean(EjemploScopeService.class);
		EjemploScopeService ejemploScopeService1 = contex.getBean(EjemploScopeService.class);
		
		log.info("Are beans equals {}", ejemploScopeService.equals(ejemploScopeService1));
		log.info("Are beans equals {}", ejemploScopeService1.equals(ejemploScopeService));
		
		String nombreAplicacion = contex.getBean(String.class);
		log.info("Nombre aplicacon {}", nombreAplicacion);
		
		AreaCalculatorService calculator = contex.getBean(AreaCalculatorService.class);
		log.info("Area total {}", calculator.calcAreas());
		
		
		ExpressionParser parse = new SpelExpressionParser();
		Expression result = parse.parseExpression("10 + 20");
		log.info("Result {} ", result.getValue());
		
		//LifeCycleBean bean = contex.getBean(LifeCycleBean.class);
		*/
		
		TargetObject bean = contex.getBean(TargetObject.class);
		bean.hello("HGello world aop");
		bean.foo();
	}
	
	@Bean
	public String getApplicationName() {
		return "Gabo 32 app";
	}
	
	//@Bean(initMethod="init", destroyMethod="destroy")
	public ExplicitBean getBean() {
		return new ExplicitBean();
	}

}
