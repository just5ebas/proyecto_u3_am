package com.uce.edu.demo.tarea33.service.funcional;

@FunctionalInterface
public interface IPredicate<T> {
	
	public boolean evaluar(T arg1); 
	
}
