package com.uce.edu.demo.factura.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
	public void insertar(Factura factura) {
		this.iFacturaRepository.insertar(factura);
	}

	@Override
	public void actualizar(Factura factura) {
		this.iFacturaRepository.actualizar(factura);
	}

	@Override
	public void eliminar(Integer id) {
		this.iFacturaRepository.eliminar(id);
	}

	@Override
	public int actualizarFecha(LocalDateTime fecha) {
		return this.iFacturaRepository.actualizarFecha(fecha);
	}

	@Override
	public Factura buscar(Integer id) {
		return this.iFacturaRepository.buscar(id);
	}

	@Override
	public Factura buscarPorNumero(String numero) {
		return this.iFacturaRepository.buscarPorNumero(numero);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal) {
		return this.iFacturaRepository.buscarFacturaInnerJoin(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoinDemanda(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaInnerJoinDemanda(subtotal);
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

	@Override
	public List<Factura> buscarFacturaWhereJoin(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaWhereJoin(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaJoinFetch(subtotal);
	}

}
