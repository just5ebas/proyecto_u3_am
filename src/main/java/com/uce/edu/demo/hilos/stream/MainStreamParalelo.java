package com.uce.edu.demo.hilos.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainStreamParalelo {

	public static void main(String[] args) {

		long tiempoInicial = System.currentTimeMillis();

		List<Integer> listaNumerosAlumnos = new ArrayList<Integer>();
		for (int i = 0; i < 5000; i++) {
			listaNumerosAlumnos.add(i);
		}

		List<String> listaProcesada = listaNumerosAlumnos.parallelStream().map(numero -> convertirIdAlumno(numero))
				.collect(Collectors.toList());

		listaProcesada.forEach(c -> System.out.println(c));

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTotal = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println("Tiempo transcurrido: " + tiempoTotal + " segs.");

	}

	public static String convertirIdAlumno(Integer id) {
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ID: " + id.toString();
	}

}
