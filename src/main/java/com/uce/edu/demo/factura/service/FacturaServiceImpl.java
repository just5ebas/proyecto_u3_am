package com.uce.edu.demo.factura.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.factura.repository.IFacturaRepository;
import com.uce.edu.demo.factura.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository iFacturaRepository;

	@Override
	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal) {
		return this.iFacturaRepository.buscarFacturaInnerJoin(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		return this.iFacturaRepository.buscarFacturaInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin(BigDecimal subtotal) {
		return this.iFacturaRepository.buscarFacturaOuterLeftJoin(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin() {
		return this.iFacturaRepository.buscarFacturaOuterLeftJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterRightJoin(BigDecimal subtotal) {
		return this.iFacturaRepository.buscarFacturaOuterRightJoin(subtotal);
	}

}
