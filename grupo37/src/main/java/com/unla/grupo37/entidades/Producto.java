package com.unla.grupo37.entidades;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nombre", nullable=false, length=45)
	private String nombre;
	
	@Column(name="descripcion", nullable=false, length=100)
	private String descripcion;
	
	private double precio;
	private boolean activo = true;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "producto", fetch = FetchType.EAGER)
	private Stock stock;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="producto")
	private Set<Compra> compras = new HashSet<>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="producto")
	private Set<Pedido> pedidos = new HashSet<>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="producto")
	private Set<Lote> lotes = new HashSet<>();
	
	public Producto() {}

	public Producto(String nombre, String descripcion, double precio, boolean activo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
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

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Set<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Set<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(Set<Lote> lotes) {
		this.lotes = lotes;
	}
	
}
