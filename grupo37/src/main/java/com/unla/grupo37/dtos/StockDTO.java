package com.unla.grupo37.dtos;

public class StockDTO {
	private long id;
	
	private int cantidadActual;
	private int cantidadCritica;
	private ProductoDTO producto;
	
	public StockDTO() {}

	public StockDTO(int cantidadActual, int cantidadCritica, ProductoDTO producto) {
		super();
		this.cantidadActual = cantidadActual;
		this.cantidadCritica = cantidadCritica;
		this.producto = producto;
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

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}
	
}
