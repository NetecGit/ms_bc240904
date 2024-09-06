package com.netec.app.practica5.service;

import java.util.List;

import com.netec.app.practica5.entities.Articulo;

public interface IArticuloService {
	List<Articulo> findAll();

	Articulo findById(int id);

	Articulo save(Articulo art);

	void deleteById(int id);

}
