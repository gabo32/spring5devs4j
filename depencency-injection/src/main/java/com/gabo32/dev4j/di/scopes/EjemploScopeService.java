package com.gabo32.dev4j.di.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
//@Scope("prototype") //se crean objetos cada que se invocan
@Scope("singleton")//escope por defecto
public class EjemploScopeService {

}
