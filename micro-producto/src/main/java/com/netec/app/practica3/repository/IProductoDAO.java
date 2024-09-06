package com.netec.app.practica3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.netec.app.practica3.entities.Producto;

public interface IProductoDAO extends CrudRepository<Producto, Integer> {

	@Query("SELECT u FROM Producto u WHERE u.nombre=:nombre")
	Optional<List<Producto>> findByName(@Param("nombre") String nombre);

}
