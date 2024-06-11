package com.unla.grupo37.dtos;

import java.time.LocalDateTime;

public class RolDeUsuarioDTO {
	
	private int id;
	private UsuarioDTO usuario;
	private String rol;
	private LocalDateTime fechaCracion;
	private LocalDateTime fechaActualizacion;

	public RolDeUsuarioDTO() {}

	public RolDeUsuarioDTO(UsuarioDTO usuario, String rol) {
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

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
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
