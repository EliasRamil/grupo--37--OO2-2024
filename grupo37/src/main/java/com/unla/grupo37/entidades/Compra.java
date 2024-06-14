package com.unla.grupo37.entidades;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="compra")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@CreationTimestamp
	private LocalDateTime fechaCompra;
	
	private int cantidadComprada;
	
	private double total;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_producto", nullable = false)
    private Producto producto;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_cliente", nullable = false)
    private Usuario cliente;

	public Compra() {}

	public Compra(int cantidadComprada, Producto producto, Usuario cliente) {
		super();
		this.cantidadComprada = cantidadComprada;
		this.producto = producto;
		this.cliente = cliente;
		this.total= cantidadComprada * producto.getPrecio();
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

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
