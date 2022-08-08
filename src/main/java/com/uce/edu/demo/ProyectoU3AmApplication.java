package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.factura.repository.modelo.Factura;
import com.uce.edu.demo.factura.service.IFacturaService;

@SpringBootApplication
public class ProyectoU3AmApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU3AmApplication.class);

	@Autowired
	private IFacturaService iFacturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// INNER
		LOG.info("INNER JOIN con condicion");
		List<Factura> listaFactura = this.iFacturaService.buscarFacturaInnerJoin(new BigDecimal(0.30));

		listaFactura.stream().forEach(f -> LOG.info("Factura 1: " + f));

		LOG.info("INNER JOIN sin condicion");
		List<Factura> listaFactura1 = this.iFacturaService.buscarFacturaInnerJoin();

		listaFactura1.stream().forEach(f -> LOG.info("Factura 2: " + f));

		// LEFT
		LOG.info("LEFT JOIN con condicion");
		List<Factura> listaFacturaLeft = this.iFacturaService.buscarFacturaOuterLeftJoin(new BigDecimal(0.30));

		listaFacturaLeft.stream().forEach(f -> LOG.info("Factura 3: " + f));

		LOG.info("LEFT JOIN sin condicion");
		List<Factura> listaFacturaLeft1 = this.iFacturaService.buscarFacturaOuterLeftJoin();

		listaFacturaLeft1.stream().forEach(f -> LOG.info("Factura 4: " + f));

		// RIGHT
		LOG.info("RIGHT JOIN con condicion");
		List<Factura> listaFacturaRight = this.iFacturaService.buscarFacturaOuterRightJoin(new BigDecimal(0.30));

		listaFacturaRight.stream().forEach(f -> LOG.info("Detalles Factura 5: " + f.getDetalles()));

	}

}
