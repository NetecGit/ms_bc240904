package com.netec.practica5.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.netec.practica5.entities.Articulo;
import com.netec.practica5.entities.Carrito;
import com.netec.practica5.feign.IArticuloFeign;

@Service
public class CarritoServiceImpl implements ICarritoService {

	private Logger LOGGER = LoggerFactory.getLogger(CarritoServiceImpl.class);

	@Autowired
	private Carrito carrito;

	@Autowired
	private IArticuloFeign feign;

	@Autowired
	private CircuitBreakerFactory cb;

	@Override
	public boolean insertArticulo(int id) {

//		Articulo art = feign.findById(id);
//
//		if (art != null) {
//			carrito.getArticulos().add(art);
//			return true;
//		}
//		return false;

		return cb.create("articulos").run(() -> {

			Articulo art = feign.findById(id);

			if (art != null) {
				carrito.getArticulos().add(art);
				return true;
			}
			return false;
		}, error -> metodoAlternativo(id));
	}

	@Override
	public List<Articulo> showAll() {

		return carrito.getArticulos();
	}

	private boolean metodoAlternativo(int id) {
		LOGGER.info("Se ejecuta metodo alternativo {}", id);
		// Logica de negocio, para responter, datos cache, datos alternativos, extraer
		// desde otra fuente datos...
		return false;
	}

}
