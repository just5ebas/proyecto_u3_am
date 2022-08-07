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

		// Relacionamiento WHERE
		LOG.info("Relacionamiento WHERE");
		List<Factura> listaWhere = this.iFacturaService.buscarFacturaWhereJoin(new BigDecimal(4));
		listaWhere.stream().forEach(f -> LOG.info("Factura WHERE: " + f));

		// INNER EAGER/LAZY
		LOG.info("INNER JOIN EAGER/LAZY");
		List<Factura> listaFactura = this.iFacturaService.buscarFacturaInnerJoinDemanda(new BigDecimal(4));

		listaFactura.stream().forEach(f -> {
			LOG.info("Factura: " + f);
			f.getDetalles().stream().forEach(d -> LOG.info("Detalles Factura: " + d));
		});

		// JOIN FETCH
		LOG.info("JOIN FETCH");
		List<Factura> listaFacturaFetch = this.iFacturaService.buscarFacturaJoinFetch(new BigDecimal(4));

		listaFacturaFetch.stream().forEach(f -> {
			LOG.info("Factura FETCH: " + f);
			f.getDetalles().stream().forEach(d -> LOG.info("Detalles Factura: " + d));
		});

	}

}
