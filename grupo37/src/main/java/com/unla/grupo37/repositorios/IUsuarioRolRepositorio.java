package com.unla.grupo37.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo37.entidades.Usuario;

@Repository("clienteRepositorio")
public interface IUsuarioRolRepositorio extends JpaRepository<Usuario, Serializable>{
	
	//@Query("SELECT u FROM Usuario u JOIN FETCH u.rolesDeUsuario r WHERE r.rol='ROL_USUARIO' and u.id= (:idUsuario)")
	
	public abstract Usuario findById(@Param("idUsuario")int id);
	
	//por ahora seria un find by id porque solo se necesita traer para mostrar en la lista de compras realizadas
	

	

}
