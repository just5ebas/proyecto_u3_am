package com.uce.edu.demo.factura.service;

import java.util.List;

import com.uce.edu.demo.factura.repository.modelo.DetalleFactura;

public interface IDetalleFacturaService {

	public void insertar(DetalleFactura detalle);

	public void actualizar(DetalleFactura detalle);

	public void eliminar(Integer id);

	public DetalleFactura buscar(Integer id);

}
