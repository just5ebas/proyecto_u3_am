package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IPersonaFunction<R, T> {
	
	public R apply(T arg1);
	
}
