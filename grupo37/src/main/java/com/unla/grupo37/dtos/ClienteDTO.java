package com.unla.grupo37.dtos;

public class ClienteDTO {
	private int id;
	private String nombreDeUsuario;
	//private List<Compra> compras;
	private double gastoTotal;
	
	public ClienteDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public double getGastoTotal() {
		return gastoTotal;
	}

	public void setGastoTotal(double gastoTotal) {
		this.gastoTotal = gastoTotal;
	}

	
	
	
	
	

}
