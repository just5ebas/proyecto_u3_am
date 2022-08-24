package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.factura.service.IFacturaService;

@SpringBootApplication
public class ProyectoU3AmApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU3AmApplication.class);

//	@Autowired
//	private IClienteService iClienteService;

	@Autowired
	private IFacturaService facturaService;

//	@Autowired
//	private IProductoService productoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Cliente c1 = new Cliente();
//		c1.setCedula("1695234871");
//		c1.setNombre("Mark");
//		c1.setApellido("Lopez");
//		c1.setNumeroTarjeta("1659-8548-6633-4848");
//
//		this.iClienteService.insertar(c1);
//
//		Producto p1 = new Producto();
//		p1.setCodigoBarras("0110011000");
//		p1.setNombre("CocaCola 3L");
//		p1.setPrecio(new BigDecimal(3.50));
//		p1.setStock(50);
//
//		Producto p2 = new Producto();
//		p2.setCodigoBarras("1110001010");
//		p2.setNombre("Shampoo");
//		p2.setPrecio(new BigDecimal(5.30));
//		p2.setStock(80);
//
//		this.productoService.insertar(p1);
//		this.productoService.insertar(p2);

		this.facturaService.crearFactura("001-001-000000007", "1918171516", "0110011000", "0110011000", "0110011000");

	}

}
