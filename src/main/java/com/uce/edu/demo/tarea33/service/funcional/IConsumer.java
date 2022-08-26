package com.uce.edu.demo.tarea33.service.funcional;

@FunctionalInterface
public interface IConsumer<T> {
	
	public void accept(T arg1);
	
}
