package com.netec.app.practica5.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netec.app.practica5.entities.Articulo;
import com.netec.app.practica5.repositories.IArticuloDAO;

@Service
public class ArticuloServiceImpl implements IArticuloService {

	@Autowired
	private IArticuloDAO dao;

	@Value("${server.port}")
	private int port;

	@Value("${server.nombre:5555}")
	private int nombre;

	@Override
	public List<Articulo> findAll() {

		return (List<Articulo>) dao.findAll();
	}

	@Override
	public Articulo findById(int id) {

		return Stream.of(dao.findById(id).orElse(null)).filter(t -> t != null).findFirst().orElse(null);
	}

	@Override
	public Articulo save(Articulo art) {

		return dao.save(art);
	}

	@Override
	public void deleteById(int id) {

		dao.deleteById(id);
	}

}
