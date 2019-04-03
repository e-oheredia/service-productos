package com.exact.productos.service.interfaces;

import com.exact.productos.entity.Producto;


public interface IProductoService {

	public Iterable<Producto> listarAll();
	Producto guardar(Producto producto);
	Iterable<Producto> listarProductosActivos();
	Producto listarById(Long id);
}
