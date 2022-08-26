package com.uce.edu.demo.tarea33.service.funcional;

@FunctionalInterface
public interface IFunction<R, T> {

	public R apply(T arg1);

}
