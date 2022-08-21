package com.uce.edu.demo.factura.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.factura.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.factura.repository.modelo.DetalleFactura;
import com.uce.edu.demo.factura.repository.modelo.Factura;
import com.uce.edu.demo.factura.repository.modelo.FacturaElectronica;

@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService {

	@Autowired
	private IFacturaElectronicaRepository iFacturaElectronicaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void insertar(FacturaElectronica facturaElectronica) {
		this.iFacturaElectronicaRepository.insertar(facturaElectronica);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void crearFacturaSRI(Factura factura) {
		
		FacturaElectronica facturaElectronica = new FacturaElectronica();
		facturaElectronica.setNumero(factura.getNumero());
		facturaElectronica.setFechaCreacion(LocalDateTime.now());
		facturaElectronica.setNumeroDetalles(factura.getDetalles().size());

		BigDecimal monto = new BigDecimal(0);

		for (DetalleFactura detalle : factura.getDetalles())
			monto = monto.add(detalle.getSubtotal());

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
