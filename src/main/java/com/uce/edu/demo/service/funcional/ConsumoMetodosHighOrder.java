package com.uce.edu.demo.service.funcional;

public class ConsumoMetodosHighOrder {

	public String consumirSupplier(IPersonaSupplier<String> funcion) {
		// Podemos implementar logica en este metodo
		return funcion.getNombre() + ", se proceso el dato.";

		/*
		 * String valor = funcion.getNombre(); Integer numero = Integer.parseInt(valor);
		 * return numero;
		 */
	}

	public void consumirConsumer(IPersonaConsumer<Integer> funcion, Integer valor) {
		funcion.accept(valor);
	}

	public boolean consumirPredicate(IPersonaPredicate<String> funcion, String valor) {
		return funcion.evaluar(valor);
	}

	public String consumirFunction(IPersonaFunction<String, Integer> funcion, Integer valor) {
		return funcion.apply(valor);
	}

}
