package com.unla.grupo37.dtos;

public class ProductoDTO {
	private long id;
	private String nombre;
	private String descripcion;
	private double precio;
	private boolean activo;
	private int cantidadActual;
	private int cantidadCritica;

	public ProductoDTO() {}

	public ProductoDTO(long id, String nombre, String descripcion, double precio, boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}
	
	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}

	public int getCantidadCritica() {
		return cantidadCritica;
	}

	public void setCantidadCritica(int cantidadCritica) {
		this.cantidadCritica = cantidadCritica;
	}
	
}