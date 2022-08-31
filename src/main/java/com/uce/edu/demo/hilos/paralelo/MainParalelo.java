package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {

		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre del hilo: " + Thread.currentThread().getName());
		CajeroParalelo c1 = new CajeroParalelo("Ariel", Arrays.asList("Pepito"));
		CajeroParalelo c2 = new CajeroParalelo("Maria", Arrays.asList("Pepito1"));
		CajeroParalelo c3 = new CajeroParalelo("Luis", Arrays.asList("Pepito2"));

		CajeroParalelo c4 = new CajeroParalelo("Andres", Arrays.asList("Pepito4"));
		CajeroParalelo c5 = new CajeroParalelo("Carla", Arrays.asList("Pepito5"));
		CajeroParalelo c6 = new CajeroParalelo("Pilar", Arrays.asList("Pepito6"));

		PCCajeroParalelo gestorAtencion = new PCCajeroParalelo(c1);
		gestorAtencion.start();

		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(c2);
		gestorAtencion2.start();

		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(c3);
		gestorAtencion3.start();

		PCCajeroParalelo gestorAtencion4 = new PCCajeroParalelo(c4);
		gestorAtencion4.start();

		PCCajeroParalelo gestorAtencion5 = new PCCajeroParalelo(c5);
		gestorAtencion5.start();

		PCCajeroParalelo gestorAtencion6 = new PCCajeroParalelo(c6);
		gestorAtencion6.start();

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTotal = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println("Tiempo transcurrido: " + tiempoTotal + " segs.");

	}

}
