package com.unla.grupo37.dtos;

import java.util.Set;

import com.unla.grupo37.entidades.Compra;

public class ProductoRankingDTO {
	private long id;
	private String nombre;
	private Set<Compra> compras;
	
	public ProductoRankingDTO() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}

	public int calcularTotal() {
		int resultado = 0;
		
		for(Compra c :this.compras)
			resultado += c.getCantidadComprada();
		
		return resultado;
	}
	
	
}
