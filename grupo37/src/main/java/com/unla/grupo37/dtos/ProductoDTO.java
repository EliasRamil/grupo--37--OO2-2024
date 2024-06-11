package com.unla.grupo37.dtos;

public class ProductoDTO {
	private int id;
	private String nombre;
	private String descripcion;
	private boolean activo;

	public ProductoDTO() {}

	public ProductoDTO(int id, String nombre, String descripcion, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getId() {
		return id;
	}
	
	public int setId() {
		return id;
	}
}