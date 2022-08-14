package com.uce.edu.demo.factura.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.factura.repository.modelo.Factura;

public interface IFacturaService {

	public void insertar(Factura factura);

	public void actualizar(Factura factura);

	public void eliminar(Integer id);

	public int actualizarFecha(LocalDateTime fecha);

	public Factura buscar(Integer id);

	public Factura buscarPorNumero(String numero);

	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal);

	public List<Factura> buscarFacturaInnerJoinDemanda(BigDecimal subtotal);

	public List<Factura> buscarFacturaInnerJoin();

	public List<Factura> buscarFacturaOuterLeftJoin(BigDecimal subtotal);

	public List<Factura> buscarFacturaOuterLeftJoin();

	public List<Factura> buscarFacturaOuterRightJoin(BigDecimal subtotal);

	public List<Factura> buscarFacturaWhereJoin(BigDecimal subtotal);

	public List<Factura> buscarFacturaJoinFetch(BigDecimal subtotal);

}
