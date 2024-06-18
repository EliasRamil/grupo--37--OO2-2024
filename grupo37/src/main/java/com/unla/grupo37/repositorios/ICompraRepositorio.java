package com.unla.grupo37.repositorios;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.grupo37.entidades.Compra;
import com.unla.grupo37.entidades.Usuario;

public interface ICompraRepositorio extends JpaRepository<Compra,Serializable>{
	
	/*public abstract Compra findById(int id);
	public abstract Compra findByFechaCompra(LocalDateTime date);
	public abstract Compra findByCliente(Usuario usuario);*/
	

}
