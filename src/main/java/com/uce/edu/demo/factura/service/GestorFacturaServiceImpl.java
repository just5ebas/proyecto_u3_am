package com.uce.edu.demo.factura.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorFacturaServiceImpl implements IGestorFacturaService {

	@Autowired
	private IFacturaService facturaService;

	@Autowired
	private IFacturaElectronicaService facturaElectronicaService;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertarFactura(String numeroFactura, String cedulaCliente, String... codigoBarras) {

		this.facturaService.crearFactura(numeroFactura, cedulaCliente, codigoBarras);

		this.facturaElectronicaService.crearFacturaSRI(numeroFactura, cedulaCliente, codigoBarras);

	}

}
