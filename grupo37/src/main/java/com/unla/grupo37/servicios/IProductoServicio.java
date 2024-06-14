package com.unla.grupo37.servicios;

import java.util.List;

import com.unla.grupo37.dtos.ProductoDTO;

public interface IProductoServicio extends IServicioGenerico<ProductoDTO> {

	List<ProductoDTO> findAllbyActivo();
	
}
