package com.unla.grupo37.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo37.entidades.Producto;

@Repository("productoRepositorio")
public interface IProductoRepositorio extends JpaRepository<Producto, Serializable> {
	
	@Query("SELECT p FROM Producto p WHERE p.idProducto = (:id)")
	public abstract Producto findByID(int id);
	
	@Query("SELECT p FROM Producto p WHERE p.nombre = (:nombre)")
	public abstract Producto findByName(String nombre);
	
	@Query("UPDATE p SET activo = 0 WHERE p.id = (:id)")
	public abstract Producto disableByID(int id);
	
	// TODO enableByID?
	
}
