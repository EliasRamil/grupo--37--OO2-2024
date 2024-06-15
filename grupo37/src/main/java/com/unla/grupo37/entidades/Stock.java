package com.unla.grupo37.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int cantidadActual;
	private int cantidadCritica;
	
	/*@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_producto", nullable = false)
	private Producto producto;*/
	
	public Stock() {}

	public Stock(int cantidadActual, int cantidadCritica) {
		super();
		this.cantidadActual = cantidadActual;
		this.cantidadCritica = cantidadCritica;
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
	
}
