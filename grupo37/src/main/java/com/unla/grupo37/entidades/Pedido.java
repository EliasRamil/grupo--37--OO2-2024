package com.unla.grupo37.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="proveedor", nullable=false, length=45)
	private String proveedor;
	
	private int cantidadPedida;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_producto", nullable = false)
    private Producto producto;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_admin", nullable = false)
    private Usuario admin;
	
	@OneToOne(mappedBy = "pedido", fetch = FetchType.LAZY)
	private Lote lote;
	
	public Pedido() {}

	public Pedido(String proveedor, int cantidadPedida, Producto producto, Usuario admin, Lote lote) {
		super();
		this.proveedor = proveedor;
		this.cantidadPedida = cantidadPedida;
		this.producto = producto;
		this.admin = admin;
		this.lote = lote;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public int getCantidadPedida() {
		return cantidadPedida;
	}

	public void setCantidadPedida(int cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuario getAdmin() {
		return admin;
	}

	public void setAdmin(Usuario admin) {
		this.admin = admin;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}
	
}
