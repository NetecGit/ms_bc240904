package com.netec.app.practica3.services;

import java.util.List;

import com.netec.app.practica3.entities.Producto;

public interface IProductoService {
	List<Producto> findAll();

	Producto save(Producto producto);

	boolean update(Producto producto);

	void deleteById(int id);

	Producto findByName(String nombre);

	Producto findById(int id);
}
