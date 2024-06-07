package com.unla.grupo37.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unla.grupo37.entidades.Usuario;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Serializable> {

	@Query("SELECT u FROM Usuario u JOIN FETCH u.rolesDeUsuario WHERE u.nombreDeUsuario = (:nombreDeUsuario)")
	public abstract Usuario findByNombreDeUsuarioAndFetchRolesDeUsuarioEagerly(@Param("nombreDeUsuario") String nombreDeUsuario);
	
}
