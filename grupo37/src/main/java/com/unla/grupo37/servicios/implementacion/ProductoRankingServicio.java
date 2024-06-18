package com.unla.grupo37.servicios.implementacion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo37.dtos.ProductoRankingDTO;
import com.unla.grupo37.entidades.Producto;
import com.unla.grupo37.repositorios.IProductoRepositorio;
import com.unla.grupo37.servicios.IProductoRankingServicio;

@Service
public class ProductoRankingServicio implements IProductoRankingServicio {

	@Autowired
	private IProductoRepositorio r;
	private ModelMapper mM = new ModelMapper();

	@Override
	public List<ProductoRankingDTO> findAll() {
		List<Producto> lProductos = r.findProductosWithCompras();
		List<ProductoRankingDTO> lRanking = new ArrayList<>();
		
		ProductoRankingDTO aux;
		for(Producto p :lProductos) {
			aux = mM.map(p, ProductoRankingDTO.class);
			lRanking.add(aux);
		}
		
		// Ordenar la lista de ProductoRankingDTO de mayor a menor basado en el total de compras
	    lRanking.sort(Comparator.comparingInt(ProductoRankingDTO::calcularTotal).reversed());
		
		return lRanking;
	}

	
}
