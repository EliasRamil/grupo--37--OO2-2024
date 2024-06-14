package com.unla.grupo37.servicios;

import java.util.List;

import com.unla.grupo37.dtos.ProductoDTO;
import com.unla.grupo37.entidades.Producto;

public interface IProductoServicio extends IServicioGenerico<ProductoDTO> {

	public Producto findByIdProducto(long id) throws Exception;
	List<ProductoDTO> findAllbyActivo();
	
}
