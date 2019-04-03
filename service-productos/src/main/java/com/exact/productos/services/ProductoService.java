package com.exact.productos.services;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.productos.dao.IProductoDao;
import com.exact.productos.entity.Producto;
import com.exact.productos.service.interfaces.IProductoService;

@Service
public class ProductoService implements IProductoService{

	@Autowired
	IProductoDao productoDao;
	
	@Override
	public Iterable<Producto> listarAll() {
		return productoDao.findAll();
	}

	@Override
	public Producto guardar(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	public Iterable<Producto> listarProductosActivos() {
		Iterable<Producto> productosBD = productoDao.findAll();
		List<Producto> productolst = StreamSupport.stream(productosBD.spliterator(), false).collect(Collectors.toList());
		productolst.removeIf(producto -> !producto.isActivo());
		return productolst;
	}

	@Override
	public Producto listarById(Long id) {
	 Optional<Producto> productobd =	productoDao.findById(id);
	 if(productobd.isPresent()) {
		 Producto producto = productobd.get();
		 return producto;
	 }
	 return null;
	}

}
