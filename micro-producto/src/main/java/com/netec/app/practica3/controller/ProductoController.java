package com.netec.app.practica3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netec.app.practica3.entities.Producto;
import com.netec.app.practica3.services.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private IProductoService servicio;

	@GetMapping("/producto")
	public List<Producto> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/producto/{id}")
	public Producto findById(@PathVariable("id") int id) {
		return servicio.findById(id);
	}

	@GetMapping("/producton/{nombre}")
	public Producto findById(@PathVariable("nombre") String nombre) {
		return servicio.findByName(nombre);
	}

	@PostMapping("/producto")
	public Producto salvarProducto(@RequestBody Producto producto) {
		return servicio.save(producto);
	}

	@PutMapping("/producto")
	public boolean actualizarProducto(@RequestBody Producto producto) {
		return servicio.update(producto);
	}

	@DeleteMapping("/producto/{id}")
	public void deleteById(@PathVariable("id") int id) {
		servicio.deleteById(id);
	}
}
