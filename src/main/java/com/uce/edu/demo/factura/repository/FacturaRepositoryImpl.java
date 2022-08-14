package com.uce.edu.demo.factura.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.factura.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Factura factura) {
		this.entityManager.persist(factura);
	}

	@Override
	public void actualizar(Factura factura) {
		this.entityManager.merge(factura);
	}

	@Override
	public int actualizarFecha(LocalDateTime fecha) {
		Query query = this.entityManager.createQuery("UPDATE Factura f SET f.fecha = :dato_fecha");
		query.setParameter("dato_fecha", fecha);
		return query.executeUpdate();
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.entityManager.find(Factura.class, id));
	}

	@Override
	public Factura buscar(Integer id) {
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public Factura buscarPorNumero(String numero) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f WHERE f.numero > :numero",
				Factura.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal) {
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f JOIN f.detalles d WHERE d.subtotal > :subtotal", Factura.class);
		myQuery.setParameter("subtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaInnerJoinDemanda(BigDecimal subtotal) {
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f JOIN f.detalles d WHERE d.subtotal > :subtotal", Factura.class);
		myQuery.setParameter("subtotal", subtotal);

		List<Factura> lista = myQuery.getResultList();

		lista.stream().forEach(f -> f.getDetalles().size());

		return lista;
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalles",
				Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin(BigDecimal subtotal) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE d.subtotal > :subtotal", Factura.class);
		myQuery.setParameter("subtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin() {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles",
				Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterRightJoin(BigDecimal subtotal) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f RIGHT JOIN f.detalles d WHERE d.subtotal > :subtotal", Factura.class);
		myQuery.setParameter("subtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaWhereJoin(BigDecimal subtotal) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f, DetalleFactura df WHERE f = df.factura AND df.subtotal > :subtotal",
				Factura.class);
		myQuery.setParameter("subtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(BigDecimal subtotal) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN FETCH f.detalles d WHERE d.subtotal > :subtotal", Factura.class);
		myQuery.setParameter("subtotal", subtotal);
		return myQuery.getResultList();
	}

}
