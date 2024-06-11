package com.unla.grupo37.dtos;

import java.time.LocalDateTime;

import com.unla.grupo37.entidades.Producto;

public class LoteDTO {
	private long id;
	
	private LocalDateTime fechaRecepcion;
	private double precioProducto;
	private int cantidadRecibida;
	
	private PedidoDTO pedido;
	
    private Producto producto;
	
	public LoteDTO() {}

	public LoteDTO(LocalDateTime fechaRecepcion, double precioProducto, int cantidadRecibida, PedidoDTO pedido,
			Producto producto) {
		super();
		this.fechaRecepcion = fechaRecepcion;
		this.precioProducto = precioProducto;
		this.cantidadRecibida = cantidadRecibida;
		this.pedido = pedido;
		this.producto = producto;
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

	public PedidoDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}
