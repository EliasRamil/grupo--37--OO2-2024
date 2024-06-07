package com.unla.grupo37.entidades;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="rol_de_usuario", uniqueConstraints=@UniqueConstraint(columnNames= {"rol", "usuario_id"}))
public class RolDeUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", nullable=false)
	private Usuario usuario;

	@Column(name="rol", nullable=false, length=100)
	private String rol;

	@CreationTimestamp
	private LocalDateTime fechaCracion;

	@UpdateTimestamp
	private LocalDateTime fechaActualizacion;

	public RolDeUsuario() {}

	public RolDeUsuario(Usuario usuario, String rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public LocalDateTime getFechaCracion() {
		return fechaCracion;
	}

	public void setFechaCracion(LocalDateTime fechaCracion) {
		this.fechaCracion = fechaCracion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

}
