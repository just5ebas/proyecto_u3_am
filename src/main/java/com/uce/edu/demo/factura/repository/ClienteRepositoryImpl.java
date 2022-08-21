package com.uce.edu.demo.factura.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.factura.repository.modelo.Cliente;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Cliente cliente) {
		this.entityManager.persist(cliente);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Cliente cliente) {
		this.entityManager.merge(cliente);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Cliente buscar(Integer id) {
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Cliente buscarPorCedula(String cedula) {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c WHERE c.cedula = :cedula",
				Cliente.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

}
