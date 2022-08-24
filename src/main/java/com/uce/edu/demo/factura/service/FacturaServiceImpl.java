package com.uce.edu.demo.factura.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.factura.repository.IClienteRepository;
import com.uce.edu.demo.factura.repository.IDetalleFacturaRepository;
import com.uce.edu.demo.factura.repository.IFacturaRepository;
import com.uce.edu.demo.factura.repository.IProductoRepository;
import com.uce.edu.demo.factura.repository.modelo.DetalleFactura;
import com.uce.edu.demo.factura.repository.modelo.Factura;
import com.uce.edu.demo.factura.repository.modelo.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService {

	private static final Logger LOG = Logger.getLogger(FacturaServiceImpl.class);

	@Autowired
	private IFacturaRepository iFacturaRepository;

	@Autowired
	private IDetalleFacturaRepository iDetalleFacturaRepository;

	@Autowired
	private IClienteRepository iClienteRepository;

	@Autowired
	private IProductoRepository iProductoRepository;

	@Autowired
	private IFacturaElectronicaService iFacturaElectronicaService;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Factura factura) {
		this.iFacturaRepository.insertar(factura);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void crearFactura(String numeroFactura, String cedulaCliente, String... codigoBarras) {
		// 1. Crear la factura con los parametros ingresados
		Factura f = new Factura();
		f.setNumero(numeroFactura);
		f.setFecha(LocalDateTime.now());
		f.setCliente(this.iClienteRepository.buscarPorCedula(cedulaCliente));

		// REQUIRES_NEW
		List<DetalleFactura> detalles = this.actualizarStockInsertarDetalle(f, codigoBarras);
		f.setDetalles(detalles);

		this.actualizar(f);

		// 3. Se crea la factura electronica
		// Debido a que tiene la transaccion REQUIRES_NEW, si falla, la creacion de la
		// factura no se vera afectada, mucho menos la actualizacion del stock del
		// producto

		this.iFacturaElectronicaService.crearFacturaSRI(f);

//		try {
//			this.iFacturaElectronicaService.crearFacturaSRI(f);
//		} catch (Exception e) {
//			LOG.error("ERROR con Factura Electronica");
//		}

	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public List<DetalleFactura> actualizarStockInsertarDetalle(Factura f, String... codigoBarras) {
		// TODO Auto-generated method stub
		this.insertar(f);

		// De los codigos ingresados, generar los detalles de la factura
		List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

		for (String codigoProducto : codigoBarras) {
			// cantidad por defecto de cada detalle es 1
			DetalleFactura detalle = new DetalleFactura();
			detalle.setCantidad(1);
			detalle.setFactura(f);
			Producto producto = this.iProductoRepository.buscarPorCodigoBarras(codigoProducto);
			detalle.setProducto(producto);

			// 2. Actualizar el stock de un producto
			producto.setStock(producto.getStock() - 1);

			if (producto.getStock() >= 0) {
				detalle.setSubtotal(detalle.getProducto().getPrecio());

				detalles.add(detalle);

				this.iDetalleFacturaRepository.insertar(detalle);

				this.iProductoRepository.actualizar(producto);
			} else {
				LOG.error("Stock agotado del producto: " + producto.getNombre());
				continue;
			}
		}

		return detalles;
		// Aqui podemos usar un cascade para insertar la factura y sus detalles
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Factura factura) {
		this.iFacturaRepository.actualizar(factura);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void eliminar(Integer id) {
		this.iFacturaRepository.eliminar(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
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
		return this.iFacturaRepository.buscarFacturaWhereJoin(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(BigDecimal subtotal) {
		return this.iFacturaRepository.buscarFacturaJoinFetch(subtotal);
	}

}
