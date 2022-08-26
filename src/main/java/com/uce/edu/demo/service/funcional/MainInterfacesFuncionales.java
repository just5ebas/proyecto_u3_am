package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static final Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {

		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();

		// --- SUPPLIER ---
		// Clases
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " + supplier.getNombre());

		IPersonaSupplier<String> supplierTE = new PersonaSupplierTEImpl();
		LOG.info("Supplier TE Clase: " + supplierTE.getNombre());

		// Lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Sebastián";
		LOG.info("Supplier Lambda: " + supplierLambda.getNombre());

		IPersonaSupplier<String> supplierLambdaTE = () -> "Cristian TE2";
		LOG.info("Supplier TE Lambda: " + supplierLambdaTE.getNombre());

		// Metodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> "Hola Mundo");
		LOG.info("High Order Supplier: " + valorHO);

		String valorHO1 = metodosHO.consumirSupplier(() -> {
			String valorConsultado = "1750844787";
			return valorConsultado;
		});
		LOG.info("HO Supplier: " + valorHO1);

		// --- CONSUMER ---
		// Clases
		IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
		consumer.accept("Prueba Consumer Clase");

		// Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");

		// Metodos High Order
		metodosHO.consumirConsumer(valor -> LOG.info("Metodos HO Consumer: " + valor), 2);

		// --- PREDICATE ---
		// Lambdas
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("d");
		LOG.info("Predicate Lambda: " + predicateLambda.evaluar("Adiel"));

		// Metodo HO
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("D"), "Buenos Días");
		LOG.info("High Order Predicate: " + respuesta);

		// --- FUNCTION ---
		// Lambdas
		IPersonaFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			return valorFinal;
		};
		LOG.info("Function Lambda: " + functionLambda.apply("7"));

		// Metodos HO
		String resp = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + "A";
			return "Valor: " + retorno;
		}, 1);
		LOG.info("High Order Function: " + resp);

		// --- UNARY OPERATOR (FUNCTION) ---
		// Lambdas
		IPersonaFunctionUnaryOperator<String> unaryLambda = cade -> {
			String valorFinal = cade.concat("-sufijo");
			return valorFinal;
		};
		LOG.info("Unary Operator Lambda: " + unaryLambda.apply("Ariel"));

	}

}
