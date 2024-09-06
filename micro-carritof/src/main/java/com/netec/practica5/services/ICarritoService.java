package com.netec.practica5.services;

import java.util.List;

import com.netec.practica5.entities.Articulo;

public interface ICarritoService {
	boolean insertArticulo(int id);

	List<Articulo> showAll();
}
