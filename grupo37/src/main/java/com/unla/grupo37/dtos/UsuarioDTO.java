package com.unla.grupo37.dtos;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class UsuarioDTO {
	private int id;

	private String nombreDeUsuario;
	private String clave;

	private boolean activada;

	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaActualizacion;
	
	private Set<RolDeUsuarioDTO> rolesDeUsuario = new HashSet<>();

	public UsuarioDTO() {}

	public UsuarioDTO(String nombreDeUsuario, String clave, boolean activada) {
		super();
		this.nombreDeUsuario = nombreDeUsuario;
		this.clave = clave;
		this.activada = activada;
	}

	public UsuarioDTO(String nombreDeUsuario, String clave, boolean activada, Set<RolDeUsuarioDTO> rolesDeUsuario) {
		super();
		this.nombreDeUsuario = nombreDeUsuario;
		this.clave = clave;
		this.activada = activada;
		this.rolesDeUsuario = rolesDeUsuario;
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isActivada() {
		return activada;
	}

	public void setActivada(boolean activada) {
		this.activada = activada;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Set<RolDeUsuarioDTO> getRolesDeUsuario() {
		return rolesDeUsuario;
	}

	public void setRolesDeUsuario(Set<RolDeUsuarioDTO> rolesDeUsuario) {
		this.rolesDeUsuario = rolesDeUsuario;
	}
	
}
