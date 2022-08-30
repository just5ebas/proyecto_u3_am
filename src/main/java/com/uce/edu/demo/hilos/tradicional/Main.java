package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long tiempoInicial = System.currentTimeMillis();

		Cajero c1 = new Cajero("Ariel", Arrays.asList("Juan", "Pepito", "Daniela", "Pedro"));
		Cajero c2 = new Cajero("Maria", Arrays.asList("Juan1", "Pepito1", "Pedro1"));
		Cajero c3 = new Cajero("Luis", Arrays.asList("Juan2", "Pedro2"));

		PCCajero gestorAtencion = new PCCajero();
		gestorAtencion.procesar(c1);
		gestorAtencion.procesar(c2);
		gestorAtencion.procesar(c3);

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTotal = (tiempoFinal - tiempoInicial) / 1000;
		
		System.out.println("Tiempo transcurrido: " + tiempoTotal + " segs.");
		
	}

}
