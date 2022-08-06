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
		
		// Relacionamiento WHERE
		LOG.info("Relacionamiento WHERE");
		List<Hotel> listaWhere = this.iHotelService.buscarHotelWhereJoin("Familiar");
		listaWhere.stream().forEach(h -> LOG.info("Hotel WHERE: " + h.getNombre()));
		
		// INNER EAGER/LAZY
		LOG.info("INNER JOIN EAGER/LAZY");
		List<Hotel> listaHotel = this.iHotelService.buscarHotelInnerJoin("Familiar");

		listaHotel.stream().forEach(h -> {
			LOG.info("Hotel: " + h.getNombre() + ", Direccion: " + h.getDireccion());
			h.getHabitaciones().stream().forEach(ha -> LOG.info("Habitacion del hotel " + h.getNombre() + ": " + ha));
		});
		
		// JOIN FETCH
		LOG.info("JOIN FETCH");
		List<Hotel> listaHotelFetch = this.iHotelService.buscarHotelJoinFetch("Familiar");

		listaHotelFetch.stream().forEach(h -> {
			LOG.info("Hotel FETCH: " + h.getNombre() + ", Direccion: " + h.getDireccion());
			h.getHabitaciones().stream().forEach(ha -> LOG.info("Habitacion del hotel " + h.getNombre() + ": " + ha));
		});

	}

}
