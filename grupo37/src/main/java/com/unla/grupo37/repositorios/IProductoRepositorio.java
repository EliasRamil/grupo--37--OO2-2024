package com.unla.grupo37.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo37.entidades.Producto;

@Repository
public interface IProductoRepositorio extends JpaRepository<Producto, Long> {

	@Query("FROM Producto p INNER JOIN FETCH p.stock")
	List<Producto> findAllProductosWithStock();
	
	@Query("FROM Producto p INNER JOIN FETCH p.stock WHERE p.id = :id")
    Producto findProductoWithStockById(@Param("id") Long id);
	
	@Query("FROM Producto p WHERE p.nombre = :nombre")
	Producto findProductoByNombre(@Param("nombre") String nombre);

}
