package com.exact.productos.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.productos.entity.Producto;

@Repository
public interface IProductoDao extends CrudRepository<Producto, Long> {

}
