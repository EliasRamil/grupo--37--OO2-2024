package com.unla.grupo37.dtos;

import java.time.LocalDateTime;

public class LoteDTO {
	private long id;
	private LocalDateTime fechaRecepcion;
	private double precioProducto;
	private int cantidadRecibida;
	private long pedidoId;
    private long productoId;
	
	public LoteDTO() {}

	public LoteDTO(long id, LocalDateTime fechaRecepcion, double precioProducto, int cantidadRecibida, long pedidoId,
			long productoId) {
		super();
		this.id = id;
		this.fechaRecepcion = fechaRecepcion;
		this.precioProducto = precioProducto;
		this.cantidadRecibida = cantidadRecibida;
		this.pedidoId = pedidoId;
		this.productoId = productoId;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(LocalDateTime fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public int getCantidadRecibida() {
		return cantidadRecibida;
	}

	public void setCantidadRecibida(int cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}

	public long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public long getProductoId() {
		return productoId;
	}

	public void setProductoId(long productoId) {
		this.productoId = productoId;
	}
	
}
