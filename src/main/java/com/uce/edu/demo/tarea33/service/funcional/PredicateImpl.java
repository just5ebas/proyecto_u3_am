package com.uce.edu.demo.tarea33.service.funcional;

import java.math.BigDecimal;

public class PredicateImpl implements IPredicate<BigDecimal> {

	@Override
	public boolean evaluar(BigDecimal arg1) {
		BigDecimal arg2 = arg1.add(new BigDecimal(1));
		BigDecimal arg3 = arg1.multiply(arg2);
		int i = arg3.compareTo(new BigDecimal(100));
		return i < 0;
	}

}
