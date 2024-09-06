package com.netec.practica5.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.netec.practica5.entities.Articulo;

// @FeignClient(name = "micro-articulo", url = "http://localhost:9091")  Sin Eureka Server
@FeignClient(name = "micro-articulo")
public interface IArticuloFeign {

	@GetMapping("/articulo/{id}")
	public abstract Articulo findById(@PathVariable("id") int id);

}
