package com.gabo32.dev4j.di.atributo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // indicamos a spring que va a manejar este objeto
public class Motor {

	@Value("Xl1")
	private String marca;
	private Integer modelo;

	public Motor() {

	}

//	public Motor(String marca, Integer modelo) {
//		super();
//		this.marca = marca;
//		this.modelo = modelo;
//	}

	public String getMarca() {
		return marca;
	}

	
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getModelo() {
		return modelo;
	}

	@Value("1982")
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Motor [marca=" + marca + ", modelo=" + modelo + "]";
	}

}
