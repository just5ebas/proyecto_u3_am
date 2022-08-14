package com.uce.edu.demo;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3AmApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU3AmApplication.class);

	@Autowired
	private ITransferenciaService iTransferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		this.iTransferenciaService.realizarTransferenciaFachada("1615143295", "1215164221", new BigDecimal(12));

	}

}
