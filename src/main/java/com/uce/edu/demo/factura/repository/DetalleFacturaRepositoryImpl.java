package com.uce.edu.demo.factura.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.factura.repository.modelo.DetalleFactura;

@Repository
@Transactional
public class DetalleFacturaRepositoryImpl implements IDetalleFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(DetalleFactura detalle) {
		this.entityManager.persist(detalle);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(DetalleFactura detalle) {
		this.entityManager.merge(detalle);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public DetalleFactura buscar(Integer id) {
		return this.entityManager.find(DetalleFactura.class, id);
	}

}
