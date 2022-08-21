package com.uce.edu.demo.factura.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.factura.repository.modelo.FacturaElectronica;

@Repository
@Transactional
public class FacturaElectronicaRepositoryImpl implements IFacturaElectronicaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(FacturaElectronica facturaElectronica) {
		this.entityManager.persist(facturaElectronica);
		throw new RuntimeException();
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(FacturaElectronica facturaElectronica) {
		this.entityManager.merge(facturaElectronica);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public FacturaElectronica buscar(Integer id) {
		return this.entityManager.find(FacturaElectronica.class, id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public FacturaElectronica buscarPorNumero(String numero) {
		TypedQuery<FacturaElectronica> myQuery = this.entityManager.createQuery(
				"SELECT fe FROM FacturaElectronica fe WHERE fe.numero = :numero", FacturaElectronica.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

}
