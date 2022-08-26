package com.uce.edu.demo.tarea33.service.funcional;

import java.math.BigDecimal;

public class FunctionUnaryOperatorImpl implements IFunctionUnaryOperator<BigDecimal> {

	@Override
	public BigDecimal apply(BigDecimal arg1) {
		arg1 = arg1.add(arg1.multiply(new BigDecimal(0.12)));
		arg1 = arg1.subtract(arg1.multiply(new BigDecimal(0.20)));
		return arg1;
	}

}
