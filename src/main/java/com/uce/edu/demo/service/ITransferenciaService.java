package com.uce.edu.demo.service;

import java.math.BigDecimal;

public interface ITransferenciaService {

	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto);

	public void realizarTransferenciaFachada(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto);

	public void realizarTransferenciaOtroBanco(String numeroOrigen, String numeroDestino, BigDecimal monto);

}
