package com.uce.edu.demo.factura.service;

public interface IGestorFacturaService {
	
	public void insertarFactura(String numeroFactura, String cedulaCliente, String... codigoBarras);
	
}
