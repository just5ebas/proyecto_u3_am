package com.uce.edu.demo.factura.repository;

import com.uce.edu.demo.factura.repository.modelo.Cliente;

public interface IClienteRepository {

	public void insertar(Cliente cliente);

	public void actualizar(Cliente cliente);

	public void eliminar(Integer id);

	public Cliente buscar(Integer id);

	public Cliente buscarPorCedula(String cedula);

}
