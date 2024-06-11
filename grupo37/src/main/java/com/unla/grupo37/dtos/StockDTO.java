package com.unla.grupo37.dtos;

public class StockDTO {
	private long id;
	private int cantidadActual;
	private int cantidadCritica;
	private long productoId;
	
	public StockDTO() {}

	public StockDTO(long id, int cantidadActual, int cantidadCritica, long productoId) {
		super();
		this.id = id;
		this.cantidadActual = cantidadActual;
		this.cantidadCritica = cantidadCritica;
		this.productoId = productoId;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
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

	public long getProductoId() {
		return productoId;
	}

	public void setProductoId(long productoId) {
		this.productoId = productoId;
	}
	
}
