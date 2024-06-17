package com.unla.grupo37.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo37.entidades.Pedido;
import com.unla.grupo37.entidades.Producto;

@Repository
public interface IPedidoRepositorio extends JpaRepository<Pedido, Long> {
	
	@Query("FROM Pedido pd INNER JOIN FETCH pd.producto INNER JOIN FETCH pd.admin")
    Producto getAllPedidosWithDetails();
	
	@Query("FROM Pedido pd INNER JOIN FETCH pd.producto INNER JOIN FETCH pd.admin WHERE pd.id = :id")
    Producto getPedidoWithDetailsById(@Param("id") Long id);
	
}
