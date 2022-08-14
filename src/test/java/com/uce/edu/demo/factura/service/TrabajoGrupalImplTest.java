package com.uce.edu.demo.factura.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.demo.factura.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.service.ICuentaBancariaService;

@SpringBootTest
@Transactional
@Rollback(true)
class TrabajoGrupalImplTest {

	@Autowired
	private IFacturaService iFacturaService;

	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;

	@Test
	void testInsertarFactura() {
//		fail("Not yet implemented");
		Factura f = new Factura();
		f.setNumero("26458964-998-998");
		f.setFecha(LocalDateTime.now());

		this.iFacturaService.insertar(f);

		assertEquals(this.iFacturaService.buscar(f.getId()), f);
	}

	@Test
	void testActualizarFactura() {
//		fail("Not yet implemented");
		Factura f = new Factura();
		f.setNumero("26458964-998-998");
		f.setFecha(LocalDateTime.now());

		this.iFacturaService.insertar(f);

		f.setNumero("001-001-121212333");

		this.iFacturaService.actualizar(f);

		assertEquals(f.getNumero(), this.iFacturaService.buscar(f.getId()).getNumero());
	}

	@Test
	void testActualizarFechaFacturas() {
//		fail("Not yet implemented");
		assertTrue(this.iFacturaService.actualizarFecha(LocalDateTime.now()) > 0);
	}

	@Test
	void testBuscarFacturaInnerJoin() {
		List<Factura> facturas = this.iFacturaService.buscarFacturaInnerJoin();
		assertThat(facturas).isNotEmpty();
	}

	@Test
	void testCrearCuenta() {
		assertThat(iCuentaBancariaService.crearCuenta("Ahorros", "852966", new BigDecimal(50))).isTrue();
	}

	@Test
	void testBuscarCuenta() {
		String numero = "1215164221";
		assertEquals(numero, this.iCuentaBancariaService.buscar(numero).getNumero());
	}

	@Test
	void testActualizarCuenta() {
		CuentaBancaria cuenta = this.iCuentaBancariaService.buscar("1215164221");
		cuenta.setTipo("Corriente");
		assertTrue(iCuentaBancariaService.actualizar(cuenta));
	}

}
