package com.uce.edu.demo.factura.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.factura.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.factura.repository.modelo.FacturaElectronica;
import com.uce.edu.demo.factura.repository.modelo.Producto;

@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService {

	@Autowired
	private IFacturaElectronicaRepository iFacturaElectronicaRepository;
	
	@Autowired
	private IProductoService iProductoService;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(FacturaElectronica facturaElectronica) {
		this.iFacturaElectronicaRepository.insertar(facturaElectronica);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void crearFacturaSRI(String numeroFactura, String cedulaCliente, String... codigoBarras) {

		FacturaElectronica facturaElectronica = new FacturaElectronica();
		facturaElectronica.setNumero(numeroFactura);
		facturaElectronica.setFechaCreacion(LocalDateTime.now());
		facturaElectronica.setNumeroDetalles(codigoBarras.length);

		BigDecimal monto = BigDecimal.ZERO;

		for (String codProducto : codigoBarras) {
			Producto p = this.iProductoService.buscarPorCodigoBarras(codProducto);
			monto = monto.add(p.getPrecio());
		}
		facturaElectronica.setMonto(monto);

		this.insertar(facturaElectronica);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(FacturaElectronica facturaElectronica) {
		this.iFacturaElectronicaRepository.actualizar(facturaElectronica);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void eliminar(Integer id) {
		this.iFacturaElectronicaRepository.eliminar(id);
	}

	@Override
	public FacturaElectronica buscar(Integer id) {
		return this.iFacturaElectronicaRepository.buscar(id);
	}

	@Override
	public FacturaElectronica buscarPorNumero(String numero) {
		return this.iFacturaElectronicaRepository.buscarPorNumero(numero);
	}

}
