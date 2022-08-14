package com.uce.edu.demo.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	@Autowired
	private ICuentaBancariaRepository cuentaRepo;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public Boolean crearCuenta(String tipo, String numero, BigDecimal monto) {
		try {
			
			CuentaBancaria cuenta = new CuentaBancaria();
			cuenta.setNumero(numero);
			cuenta.setTipo(tipo);
			this.cuentaRepo.insertar(cuenta);

			CuentaBancaria cuentaDepositar = cuenta;
			cuentaDepositar.setSaldo(monto);
			this.cuentaRepo.actualizar(cuentaDepositar);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public CuentaBancaria buscar(String numero) {
		return this.cuentaRepo.buscarPorNumero(numero);
	}

	@Override
	public Boolean actualizar(CuentaBancaria cuentaBancaria) {
		try {
			this.cuentaRepo.actualizar(cuentaBancaria);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
