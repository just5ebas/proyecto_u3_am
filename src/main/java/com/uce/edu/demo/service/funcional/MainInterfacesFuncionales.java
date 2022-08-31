package com.uce.edu.demo.service.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static final Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static boolean prueba(Integer numero) {
		return numero >= 3;
	}

	public static void imprimir(String cadena) {
		LOG.info("Impresión: " + cadena);
	}

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

		// JAVA
		LOG.info("JAVA Supplier: ");
		Stream<String> test = Stream.generate(() -> "Ariel M.").limit(2);
		test.forEach(str -> System.out.println(str));

		// --- CONSUMER ---
		// Clases
		IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
		consumer.accept("Prueba Consumer Clase");

		// Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");

		// Metodos High Order
		metodosHO.consumirConsumer(valor -> LOG.info("Metodos HO Consumer: " + valor), 2);

		// JAVA
		LOG.info("JAVA Consumer: ");
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5);
		listaNumeros.forEach(numero -> LOG.info(numero));

		// --- PREDICATE ---
		// Lambdas
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("d");
		LOG.info("Predicate Lambda: " + predicateLambda.evaluar("Adiel"));

		// Metodo HO
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("D"), "Buenos Días");
		LOG.info("High Order Predicate: " + respuesta);

		// JAVA
		LOG.info("JAVA Predicate");
		Stream<Integer> nuevaLista = listaNumeros.stream().filter(numero -> prueba(numero));
		nuevaLista.forEach(numero -> System.out.println(numero));

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

		// JAVA
		LOG.info("JAVA Function: ");
		Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> {
			Integer valor = numeroLista + 1;
			String cad = "Num: " + valor.toString();
			return cad;
		});
		// Declarativa: ideas / intenciones
		listaCambiada.forEach(valor -> imprimir(valor));

		// Tipos de colecciones
//		List<String> lista1 = new ArrayList<String>();
//		Map<String, String> mapa1 = new HashMap<>();
		
		// --- UNARY OPERATOR (FUNCTION) ---
		// Lambdas
		IPersonaFunctionUnaryOperator<String> unaryLambda = cade -> {
			String valorFinal = cade.concat("-sufijo");
			return valorFinal;
		};
		LOG.info("Unary Operator Lambda: " + unaryLambda.apply("Ariel"));

	}

}
