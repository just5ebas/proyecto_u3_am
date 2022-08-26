package com.uce.edu.demo.tarea33.service.funcional;

import java.math.BigDecimal;

public class FunctionImpl implements IFunction<String, BigDecimal> {

	@Override
	public String apply(BigDecimal arg1) {
		BigDecimal iva = arg1.multiply(new BigDecimal(0.12));
		String ret = "Subtotal sin IVA: " + arg1;
		ret.concat("\nSubtotal con IVA: " + (arg1.add(iva)));
		return ret;
	}

}
