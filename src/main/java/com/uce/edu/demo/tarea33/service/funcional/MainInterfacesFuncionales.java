package com.uce.edu.demo.tarea33.service.funcional;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static final Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {

		ConsMetodosHighOrder metodosHighOrder = new ConsMetodosHighOrder();

		// SUPPLIER
		ISupplier<String> supplierClase = new SupplierImpl();
		LOG.info("Clase Supplier: " + supplierClase.get());

		ISupplier<String> supplierLambda = () -> "Firma de Empresa: Games&Games";
		LOG.info("Lambda Supplier: " + supplierLambda.get());

		LOG.info("Metodo HO Supplier: " + metodosHighOrder.consumirSupplier(() -> "0.12"));

		// CONSUMER
		LOG.info("Clase Consumer:");
		IConsumer<String> consumerClase = new ConsumerImpl();
		consumerClase.accept("EnTraDA dE DaTOs");

		LOG.info("Lambda Consumer:");
		IConsumer<String> consumerLambda = s -> {
			LOG.info(s);
			s = s.concat(" tamaño de la cadena: " + s.length());
			LOG.info(s);
		};

		LOG.info("Metodos HO Consumer:");
		metodosHighOrder.consumirConsumer(cad -> LOG.info(cad.replaceAll("a", "o")), "andando arriba alto");

		// PREDICATE
		IPredicate<BigDecimal> predicateClase = new PredicateImpl();
		boolean predC = predicateClase.evaluar(new BigDecimal(12));
		LOG.info("Clase Predicate: evaluacion en '" + predC + "'");

		IPredicate<BigDecimal> predicateLambda = arg1 -> {
			BigDecimal arg2 = arg1.add(arg1.multiply(new BigDecimal(0.12)));
			if (arg2.subtract(arg1).compareTo(BigDecimal.ONE) > 0)
				return true;
			return false;
		};
		boolean predL = predicateLambda.evaluar(new BigDecimal(4.66));
		LOG.info("Lambda Predicate: evaluacion en '" + predL + "'");

		boolean predHO = metodosHighOrder.consumirPredicate(val -> val > 0, -6);
		LOG.info("Metodos HO Predicate: evaluacion en '" + predHO + "'");

		// FUNCTION
		IFunction<String, BigDecimal> functionClase = new FunctionImpl();
		String funcC = functionClase.apply(new BigDecimal(16.35));
		LOG.info("Clase Function: " + funcC);

		IFunction<String, BigDecimal> functionLambda = monto -> "Precio de God of War: $" + monto.doubleValue();
		String funcL = functionLambda.apply(new BigDecimal(20.00));
		LOG.info("Lambda Function: " + funcL);

		String funcHO = metodosHighOrder.consumirFunction(val -> val.toString().concat(" unidades entregadas."), 30);
		LOG.info("Metodos HO Function: " + funcHO);

		// UNARY OPERATOR
		IFunctionUnaryOperator<BigDecimal> functionUnaryClase = new FunctionUnaryOperatorImpl();
		BigDecimal unarC = functionUnaryClase.apply(new BigDecimal(15));
		LOG.info("Clase UnaryOperator: retorno " + unarC.doubleValue());
		
		IFunctionUnaryOperator<BigDecimal> functionUnaryLambda = valor -> {
			valor = valor.subtract(valor.multiply(new BigDecimal(0.2)));
			valor = valor.add(valor.multiply(new BigDecimal(0.12)));
			return valor;
		};
		BigDecimal unarL = functionUnaryLambda.apply(new BigDecimal(15));
		LOG.info("Lambda UnaryOperator: retorno " + unarC);
		
		BigDecimal unarHO = metodosHighOrder.consumirUnaryOperator(x -> x.add(x.divide(BigDecimal.TEN)), new BigDecimal(46));
		LOG.info("Metodos HO UnaryOperator: retorno " + unarHO);

	}

}
