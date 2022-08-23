package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static final Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {

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

		// --- CONSUMER ---
		// Clases
		IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
		consumer.accept("Prueba Consumer Clase");

		// Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");

		// --- PREDICATE ---
		// Clases

		// Lambdas

		// --- FUNCTION ---
		// Clases

		// Lambdas

		// --- UNARY OPERATOR (FUNCTION) ---
		// Clases

		// Lambdas

	}

}
