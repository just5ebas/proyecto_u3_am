package com.uce.edu.demo.tarea33.service.funcional;

import org.apache.log4j.Logger;

public class ConsumerImpl implements IConsumer<String> {

	private static final Logger LOG = Logger.getLogger(ConsumerImpl.class);

	@Override
	public void accept(String arg1) {
		LOG.info("Consumiendo: " + arg1);
		arg1 = arg1.toLowerCase();
		LOG.info("Minúsculas: " + arg1);
	}

}
