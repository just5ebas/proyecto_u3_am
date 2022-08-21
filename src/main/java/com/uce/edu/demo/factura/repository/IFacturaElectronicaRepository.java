package com.uce.edu.demo.factura.repository;

import com.uce.edu.demo.factura.repository.modelo.FacturaElectronica;

public interface IFacturaElectronicaRepository {

	public void insertar(FacturaElectronica facturaElectronica);

	public void actualizar(FacturaElectronica facturaElectronica);

	public void eliminar(Integer id);

	public FacturaElectronica buscar(Integer id);

	public FacturaElectronica buscarPorNumero(String numero);

}
