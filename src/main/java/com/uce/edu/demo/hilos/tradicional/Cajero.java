package com.uce.edu.demo.hilos.tradicional;

import java.util.List;

public class Cajero {

	private String nombre;
	private List<String> clientes;

	public Cajero(String nombre, List<String> clientes) {
		this.nombre = nombre;
		this.clientes = clientes;
	}

	// GET & SET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getClientes() {
		return clientes;
	}

	public void setClientes(List<String> clientes) {
		this.clientes = clientes;
	}

}
