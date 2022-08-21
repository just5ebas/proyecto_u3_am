package com.uce.edu.demo.factura.repository;

import com.uce.edu.demo.factura.repository.modelo.DetalleFactura;

public interface IDetalleFacturaRepository {
	
	public void insertar(DetalleFactura detalle);

	public void actualizar(DetalleFactura detalle);

	public void eliminar(Integer id);

	public DetalleFactura buscar(Integer id);
	
}
