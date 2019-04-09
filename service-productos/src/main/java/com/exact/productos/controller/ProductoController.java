package com.exact.productos.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exact.productos.entity.Producto;
import com.exact.productos.service.interfaces.IProductoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	IProductoService productoService;
	
	@GetMapping
	public ResponseEntity<Iterable<Producto>> listarAll() {
		return new ResponseEntity<Iterable<Producto>>(productoService.listarAll(), HttpStatus.OK);
	}
	
	@GetMapping("/activos")
	public ResponseEntity<Iterable<Producto>> listarActivos() {
		return new ResponseEntity<Iterable<Producto>>(productoService.listarProductosActivos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> listarById(@PathVariable Long id){
		Producto producto = productoService.listarById(id);
		return new ResponseEntity<Producto>(producto, producto == null ? HttpStatus.NOT_FOUND: HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Producto> guardar(@RequestBody String producto)  {
		ObjectMapper mapper = new ObjectMapper();
		Producto productoBD=null;
		try {
			productoBD = mapper.readValue(producto, Producto.class);
			productoBD.setActivo(true);
			return new ResponseEntity<Producto>(productoService.guardar(productoBD), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Producto> modificar(@PathVariable Long id,@RequestBody String producto) {
		ObjectMapper mapper = new ObjectMapper();
		Producto productoBD=null;
		try {
			productoBD = mapper.readValue(producto, Producto.class);
			productoBD.setId(id);
			return new ResponseEntity<Producto>(productoService.guardar(productoBD), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
