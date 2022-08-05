package com.uce.edu.demo.factura.repository;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.demo.factura.repository.modelo.Factura;

public interface IFacturaRepository {

	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal);

	public List<Factura> buscarFacturaInnerJoin();

	public List<Factura> buscarFacturaOuterLeftJoin(BigDecimal subtotal);

	public List<Factura> buscarFacturaOuterLeftJoin();

	public List<Factura> buscarFacturaOuterRightJoin(BigDecimal subtotal);

}
