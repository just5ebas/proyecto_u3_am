package com.uce.edu.demo.factura.repository;

import com.uce.edu.demo.factura.repository.modelo.Producto;

public interface IProductoRepository {

	public void insertar(Producto producto);

	public void actualizar(Producto producto);

	public void eliminar(Integer id);

	public Producto buscar(Integer id);

	public Producto buscarPorCodigoBarras(String codigoBarras);

}
