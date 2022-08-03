package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3AmApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU3AmApplication.class);

	@Autowired
	private IHotelService iHotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// INNER
		LOG.info("INNER JOIN con condicion");
		List<Hotel> listaHotel = this.iHotelService.buscarHotelInnerJoin("Familiar");

		listaHotel.stream().forEach(h -> LOG.info("Hotel: " + h.getNombre() + ", Direccion: " + h.getDireccion()));

		LOG.info("INNER JOIN sin condicion");
		List<Hotel> listaHotel1 = this.iHotelService.buscarHotelInnerJoin();

		listaHotel1.stream().forEach(h -> LOG.info("Hotel2: " + h.getNombre() + ", Direccion: " + h.getDireccion()));

		// LEFT
		LOG.info("LEFT JOIN con condicion");
		List<Hotel> listaHotelLeft = this.iHotelService.buscarHotelOuterLeftJoin("Familiar");

		listaHotelLeft.stream().forEach(h -> LOG.info("Hotel3: " + h.getNombre() + ", Direccion: " + h.getDireccion()));

		LOG.info("LEFT JOIN sin condicion");
		List<Hotel> listaHotelLeft1 = this.iHotelService.buscarHotelOuterLeftJoin();

		listaHotelLeft1.stream().forEach(h -> LOG.info("Hotel4: " + h.getNombre() + ", Direccion: " + h.getDireccion()));

		// RIGHT
		LOG.info("RIGHT JOIN con condicion");
		List<Hotel> listaHotelRight = this.iHotelService.buscarHotelOuterRightJoin("Familiar");

		listaHotelRight.stream().forEach(h -> LOG.info("Hotel5: " + h.getNombre() + ", Direccion: " + h.getDireccion()));
	}

}
