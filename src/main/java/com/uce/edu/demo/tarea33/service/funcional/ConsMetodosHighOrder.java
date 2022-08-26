package com.uce.edu.demo.tarea33.service.funcional;

import java.math.BigDecimal;

public class ConsMetodosHighOrder {

	public Double consumirSupplier(ISupplier<String> funcion) {
		return Double.parseDouble(funcion.get());
	}

	public void consumirConsumer(IConsumer<String> funcion, String valor) {
		valor = valor.concat(" ¡Hola Mundo!");
		funcion.accept(valor);
	}

	public boolean consumirPredicate(IPredicate<Integer> funcion, Integer i) {
		return funcion.evaluar(i);
	}

	public String consumirFunction(IFunction<String, Integer> funcion, Integer valor) {
		valor = valor * valor;
		return funcion.apply(valor);
	}

	public BigDecimal consumirUnaryOperator(IFunctionUnaryOperator<BigDecimal> funcion, BigDecimal valor) {
		valor = valor.multiply(new BigDecimal(0.8));
		return funcion.apply(valor);
	}

}
