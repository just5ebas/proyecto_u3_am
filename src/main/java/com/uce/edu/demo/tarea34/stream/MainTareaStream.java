package com.uce.edu.demo.tarea34.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class MainTareaStream {

	private static final Logger LOG = Logger.getLogger(MainTareaStream.class);

	public static void main(String[] args) {

		// Supplier
		LOG.info("SUPPLIER: genera un arreglo de 5 elementos con el mismo string.");
		Stream<String> listaJuegos = Stream.generate(() -> "God of War").limit(5);

		// Consumer
		LOG.info("CONSUMER: imprime el arreglo creado anteriormente.");
		listaJuegos.forEach(str -> LOG.info("Videojuego: " + str));

		// Predicate
		LOG.info("PREDICATE: filtra unicamente los videojuegos que en su nombre contenga la letra 'r'");
		List<String> listaJ = Arrays.asList("God of War", "The Last of Us", "Far Cry 6", "Death Stranding");
		Stream<String> listaFiltro = listaJ.stream().filter(str -> str.contains("r"));
		listaFiltro.forEach(juego -> LOG.info("Filtro: " + juego));

		// Function
		LOG.info("FUNCTION: mapea los nombres de los videojuegos a un String pero con mayusculas");
		listaJ.stream().map(juego -> juego.toUpperCase()).forEach(juego -> LOG.info("Mapeo: " + juego));

	}

}
