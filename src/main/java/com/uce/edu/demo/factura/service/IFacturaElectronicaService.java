package com.uce.edu.demo.factura.service;

import com.uce.edu.demo.factura.repository.modelo.FacturaElectronica;

public interface IFacturaElectronicaService {

	public void insertar(FacturaElectronica facturaElectronica);
	
	public void crearFacturaSRI(String numeroFactura, String cedulaCliente, String... codigoBarras);

	public void actualizar(FacturaElectronica facturaElectronica);

	public void eliminar(Integer id);

	public FacturaElectronica buscar(Integer id);

	public FacturaElectronica buscarPorNumero(String numero);

}
