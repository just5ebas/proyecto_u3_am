package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

import com.uce.edu.demo.hilos.tradicional.Cajero;

public class PCCajeroParalelo extends Thread {

	private CajeroParalelo cajero;

	public PCCajeroParalelo(CajeroParalelo cajero) {
		this.cajero = cajero;
	}

	// Disparar el metodo a paralelizar
	// No podemos alterar la firma de este metodo
	@Override
	public void run() {
		this.procesar(this.cajero);
	}

	public void procesar(CajeroParalelo cajero) {

		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre del hilo procesar: " + Thread.currentThread().getName());
		System.out.println("Procesando cajero de: " + cajero.getNombre());

		cajero.getClientes().forEach(cad -> atenderCliente(cad));

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTotal = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println("Termino: " + cajero.getNombre() + " en: " + tiempoTotal + " segs.");

	}

	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo cliente: " + cliente);
		// Duerme 10 segundos al hilo
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
