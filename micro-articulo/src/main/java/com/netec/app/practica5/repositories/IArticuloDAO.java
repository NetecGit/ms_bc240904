package com.netec.app.practica5.repositories;

import org.springframework.data.repository.CrudRepository;

import com.netec.app.practica5.entities.Articulo;

public interface IArticuloDAO extends CrudRepository<Articulo, Integer> {

}
