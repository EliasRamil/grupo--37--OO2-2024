package com.unla.grupo37.dtos;

public class PedidoDTO {
	private long id;
	
	private String proveedor;
	
	private int cantidadPedida;
    private ProductoDTO producto;
    private UsuarioDTO admin;
	private LoteDTO lote;
	
	public PedidoDTO() {}

	public PedidoDTO(String proveedor, int cantidadPedida, ProductoDTO producto, UsuarioDTO admin, LoteDTO lote) {
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

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}

	public UsuarioDTO getAdmin() {
		return admin;
	}

	public void setAdmin(UsuarioDTO admin) {
		this.admin = admin;
	}

	public LoteDTO getLote() {
		return lote;
	}

	public void setLote(LoteDTO lote) {
		this.lote = lote;
	}
	
}
