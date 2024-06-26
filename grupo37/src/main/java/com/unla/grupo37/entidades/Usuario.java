package com.unla.grupo37.entidades;

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

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="nombreDeUsuario", unique=true, nullable=false, length=45)
	private String nombreDeUsuario;

	@Column(name="clave", nullable=false, length=60)
	private String clave;

	private boolean activada;

	@CreationTimestamp
	private LocalDateTime fechaCreacion;

	@UpdateTimestamp
	private LocalDateTime fechaActualizacion;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
	private Set<RolDeUsuario> rolesDeUsuario = new HashSet<>(); //preguntar mañana

	public Usuario() {}

	public Usuario(String nombreDeUsuario, String clave, boolean activada) {
		super();
		this.nombreDeUsuario = nombreDeUsuario;
		this.clave = clave;
		this.activada = activada;
	}

	public Usuario(String nombreDeUsuario, String clave, boolean activada, Set<RolDeUsuario> rolesDeUsuario) {
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

	public Set<RolDeUsuario> getRolesDeUsuario() {
		return rolesDeUsuario;
	}

	public void setRolesDeUsuario(Set<RolDeUsuario> rolesDeUsuario) {
		this.rolesDeUsuario = rolesDeUsuario;
	}
	
}
