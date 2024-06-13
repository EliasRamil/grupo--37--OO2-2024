package com.unla.grupo37.servicios.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.unla.grupo37.dtos.ProductoDTO;
import com.unla.grupo37.entidades.Producto;
import com.unla.grupo37.entidades.Stock;
import com.unla.grupo37.repositorios.IProductoRepositorio;
import com.unla.grupo37.repositorios.IRepositorioGenerico;
import com.unla.grupo37.servicios.IServicioGenerico;

public class ProductoServicio implements IServicioGenerico<ProductoDTO> {

	@Autowired
	private IProductoRepositorio rP;
	@Autowired
	private IRepositorioGenerico<Stock> rS;
	private ModelMapper mM = new ModelMapper();
	
	@Override
	public List<ProductoDTO> findAll() {
		List<Producto> productos = rP.findAll();
		List<ProductoDTO> productosDTOs = new ArrayList<>();
		
		ProductoDTO aux;
		for(Producto p :productos) {
			aux = mM.map(p, ProductoDTO.class);
			aux.setCantidadActual(p.getStock().getCantidadActual());
			aux.setCantidadCritica(p.getStock().getCantidadCritica());
			productosDTOs.add(aux);
		}
		
		return productosDTOs;
	}

	@Override
	public ProductoDTO findById(long id) throws Exception {
		Producto p = rP.findById(id).orElse(null);
		
		if(p == null)
			throw new Exception("No existe el Producto con el id: " + id);
		
		ProductoDTO aux = mM.map(p, ProductoDTO.class);
		aux.setCantidadActual(p.getStock().getCantidadActual());
		aux.setCantidadCritica(p.getStock().getCantidadCritica());
		
		return aux;
	}

	@Override
	public ProductoDTO saveOne(ProductoDTO dto) throws Exception {
		ProductoDTO retorno = null;
		
		try {
			Producto p = rP.save(mM.map(dto, Producto.class));
			rS.save(new Stock(0, 0, p));
			retorno = mM.map(p, ProductoDTO.class);
		} catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		return retorno;
	}

	@Override
	public ProductoDTO updateOne(ProductoDTO dto, long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(long id) throws Exception {
		Producto p = rP.findById(id).orElse(null);
		
		if(p == null)
			throw new Exception("No existe el Producto con el id: " + id);
		
		p.setActivo(false);
		
		return true;
	}

}
