package com.unla.grupo37.dtos;

import java.time.LocalDateTime;

public class CompraDTO {
	private long id;
	private LocalDateTime fechaCompra;
	private int cantidadComprada;
    private long productoId;
    private long clienteId;

	public CompraDTO() {}

	public CompraDTO(long id, LocalDateTime fechaCompra, int cantidadComprada, long productoId, long clienteId) {
		super();
		this.id = id;
		this.fechaCompra = fechaCompra;
		this.cantidadComprada = cantidadComprada;
		this.productoId = productoId;
		this.clienteId = clienteId;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public int getCantidadComprada() {
		return cantidadComprada;
	}

	public void setCantidadComprada(int cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}

	public long getProductoId() {
		return productoId;
	}

	public void setProductoId(long productoId) {
		this.productoId = productoId;
	}

	public long getClienteId() {
		return clienteId;
	}

	public void setClienteId(long clienteId) {
		this.clienteId = clienteId;
	}
	
}
