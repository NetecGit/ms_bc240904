package com.netec.app.practica3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.netec.app.practica3.entities.Producto;
import com.netec.app.practica3.repository.IProductoDAO;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoDAO dao;

	@Override
	public List<Producto> findAll() {
		Iterable<Producto> resultado = dao.findAll();
		return (List<Producto>) resultado;
	}

	@Override
	public Producto save(Producto producto) {

		return dao.save(producto);
	}

	@Override
	public boolean update(Producto producto) {
		// primera version if/else

		if (dao.existsById(producto.getId())) {
			dao.save(producto);
			return true;
		}
		// return false;
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado " + producto.getId());
	}

	@Override
	public void deleteById(int id) {

		if (dao.existsById(id)) {
			dao.deleteById(id);
			return;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado " + id);

	}

	@Override
	public Producto findByName(String nombre) {

		// return dao.findByName(nombre).stream().findFirst().orElseThrow(() -> new
		// ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado: " +
		// nombre));

		// return dao.findByName(nombre).get(0);

		return dao.findByName(nombre).get().stream().findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado: " + nombre));
	}

	@Override
	public Producto findById(int id) {

		return dao.findById(id).stream().findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado: " + id));
	}

}
