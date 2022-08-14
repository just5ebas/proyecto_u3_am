package com.uce.edu.demo.service;

import java.math.BigDecimal;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {

	public Boolean crearCuenta(String tipo, String numero, BigDecimal monto);

	public CuentaBancaria buscar(String numero);

	public Boolean actualizar(CuentaBancaria cuentaBancaria);

}
