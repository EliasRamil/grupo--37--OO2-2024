package com.unla.grupo37.servicios;

import java.util.List;

import com.unla.grupo37.dtos.DegreeDTO;
import com.unla.grupo37.dtos.ProductoDTO;
import com.unla.grupo37.entidades.Degree;
import com.unla.grupo37.entidades.Producto;

public interface IProductoServicio {

	public List<Producto> getAll();
	public ProductoDTO insertOrUpdate(ProductoDTO pDTO);
	public boolean disable(int id);
	
}
