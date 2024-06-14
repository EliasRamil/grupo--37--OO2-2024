package com.unla.grupo37.servicios.implementacion;

import org.springframework.stereotype.Service;

import com.unla.grupo37.entidades.Usuario;
import com.unla.grupo37.repositorios.IUsuarioRolRepositorio;

@Service
public class UsuarioRolServicio{
	
	private IUsuarioRolRepositorio repositorioCliente;
	
	public UsuarioRolServicio(IUsuarioRolRepositorio repositorioCliente){
	  this.repositorioCliente = repositorioCliente;
	}
	
	public Usuario getClienteById(int id) {
		return repositorioCliente.findById(id);
	}
	
	
}
