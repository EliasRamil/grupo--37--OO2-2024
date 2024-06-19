package com.unla.grupo37.servicios;

import java.util.List;

import com.unla.grupo37.dtos.ProductoRankingDTO;

public interface IProductoRankingServicio {
	
	public List<ProductoRankingDTO> findAll();
	
}
