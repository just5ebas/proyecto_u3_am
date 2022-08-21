package com.uce.edu.demo.factura.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.factura.repository.IProductoRepository;
import com.uce.edu.demo.factura.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Producto producto) {
		this.iProductoRepository.insertar(producto);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Producto producto) {
		this.iProductoRepository.actualizar(producto);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void eliminar(Integer id) {
		this.iProductoRepository.eliminar(id);
	}

	@Override
	public Producto buscar(Integer id) {
		return this.iProductoRepository.buscar(id);
	}

	@Override
	public Producto buscarPorCodigoBarras(String codigoBarras) {
		return this.iProductoRepository.buscarPorCodigoBarras(codigoBarras);
	}

}
