package com.uce.edu.demo.tarea35.hilos;

import java.util.concurrent.TimeUnit;

public class Consola extends Thread {

	private Jugador jugador;

	public Consola(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public void run() {
		this.iniciarSesion(this.jugador);
	}

	private void iniciarSesion(Jugador jugador) {
		System.out.println("\nNombre del hilo: " + Thread.currentThread().getName() + "\n");

		int tiempo = this.verificarTag(jugador.getGamerTag());

		long tiempoInicial = System.currentTimeMillis();

		try {
			TimeUnit.SECONDS.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTotal = (tiempoFinal - tiempoInicial) / 1000;

		// Supondre que el tiempo es el tiempo que el usuario esta conectado y que este
		// esta en horas

		System.out.println("Tiempo online del jugador " + jugador.getGamerTag() + ": " + tiempoTotal + " horas.");

	}

	private int verificarTag(String gamerTag) {
		System.out.println("Bienvenido, " + gamerTag);
		switch (gamerTag) {
		case "theCarloxV":
			return 3;
		case "dimal316":
			return 10;
		case "just5ebas":
			return 13;
		case "majinomaha":
			return 25;
		default:
			return 5;
		}
	}

}
