package com.netec.practica5.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netec.practica5.entities.Articulo;
import com.netec.practica5.entities.Carrito;
import com.netec.practica5.feign.IArticuloFeign;

@Service
public class CarritoServiceImpl implements ICarritoService {

	@Autowired
	private Carrito carrito;

	@Autowired
	private IArticuloFeign feign;

	@Override
	public boolean insertArticulo(int id) {
		Articulo art = feign.findById(id);

		if (art != null) {
			carrito.getArticulos().add(art);
			return true;
		}
		return false;
	}

	@Override
	public List<Articulo> showAll() {

		return carrito.getArticulos();
	}

}
