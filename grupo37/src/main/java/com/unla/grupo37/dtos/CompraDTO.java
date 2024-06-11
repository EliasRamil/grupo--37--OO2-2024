package com.unla.grupo37.dtos;

import java.time.LocalDateTime;

import com.unla.grupo37.entidades.Producto;

public class CompraDTO {
	private long id;
	
	private LocalDateTime fechaCompra;
	private int cantidadComprada;
	
    private Producto producto;
	
    private UsuarioDTO cliente;

	public CompraDTO() {}

	public CompraDTO(LocalDateTime fechaCompra, int cantidadComprada, Producto producto, UsuarioDTO cliente) {
		super();
		this.fechaCompra = fechaCompra;
		this.cantidadComprada = cantidadComprada;
		this.producto = producto;
		this.cliente = cliente;
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

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public UsuarioDTO getCliente() {
		return cliente;
	}

	public void setCliente(UsuarioDTO cliente) {
		this.cliente = cliente;
	}
	
}
