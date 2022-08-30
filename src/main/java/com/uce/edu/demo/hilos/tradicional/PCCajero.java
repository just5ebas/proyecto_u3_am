package com.uce.edu.demo.hilos.tradicional;

import java.util.concurrent.TimeUnit;

public class PCCajero {

	public void procesar(Cajero cajero) {
		System.out.println("Procesando cajero de: " + cajero.getNombre());

		cajero.getClientes().forEach(cad -> atenderCliente(cad));
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
