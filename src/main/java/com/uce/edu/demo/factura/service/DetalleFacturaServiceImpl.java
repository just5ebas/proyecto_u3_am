package com.uce.edu.demo.factura.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.factura.repository.IDetalleFacturaRepository;
import com.uce.edu.demo.factura.repository.modelo.DetalleFactura;

@Service
public class DetalleFacturaServiceImpl implements IDetalleFacturaService {

	@Autowired
	private IDetalleFacturaRepository iDetalleFacturaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(DetalleFactura detalle) {
		this.iDetalleFacturaRepository.insertar(detalle);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(DetalleFactura detalle) {
		this.iDetalleFacturaRepository.actualizar(detalle);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void eliminar(Integer id) {
		this.iDetalleFacturaRepository.eliminar(id);
	}

	@Override
	public DetalleFactura buscar(Integer id) {
		return this.iDetalleFacturaRepository.buscar(id);
	}

}
