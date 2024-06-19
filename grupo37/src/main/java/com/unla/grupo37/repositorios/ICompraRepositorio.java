package com.unla.grupo37.repositorios;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unla.grupo37.entidades.Compra;

public interface ICompraRepositorio extends JpaRepository<Compra,Serializable>{
	
	@Query("FROM Compra c JOIN FETCH c.cliente cl WHERE cl.id= :id ")
	public abstract List<Compra> findAllComprasByIdCliente(@Param("id") int id);
	

}
