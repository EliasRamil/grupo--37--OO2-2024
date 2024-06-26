package com.unla.grupo37.servicios.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unla.grupo37.dtos.ProductoDTO;
import com.unla.grupo37.entidades.Producto;
import com.unla.grupo37.entidades.Stock;
import com.unla.grupo37.repositorios.IProductoRepositorio;
import com.unla.grupo37.servicios.IProductoServicio;

@Service
@Transactional
public class ProductoServicio implements IProductoServicio {

	@Autowired
	private IProductoRepositorio rP;
	private ModelMapper mM = new ModelMapper();
	
	@Override
	public List<ProductoDTO> findAll() {
		List<Producto> productos = rP.findAllProductosWithStock();
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
		Producto p = rP.findProductoWithStockById(id);
		
		if(p == null)
			throw new Exception("No existe el Producto con el id: " + id);
		
		ProductoDTO aux = mM.map(p, ProductoDTO.class);
		aux.setCantidadActual(p.getStock().getCantidadActual());
		aux.setCantidadCritica(p.getStock().getCantidadCritica());
		
		return aux;
	}
	
	public Producto findByIdProducto(long id) throws Exception {
		Producto p = rP.findProductoWithStockById(id);
		
		if(p == null)
			throw new Exception("No existe el Producto con el id: " + id);
		
		return p;
	}

	@Override
	public ProductoDTO saveOne(ProductoDTO dto) throws Exception {
		ProductoDTO retorno = null;
		
		try {
			Producto p = mM.map(dto, Producto.class);
			p.setStock(new Stock(dto.getCantidadActual(), dto.getCantidadCritica()));
			p.setActivo(true);
			rP.save(p);
			retorno = mM.map(p, ProductoDTO.class);
			retorno.setCantidadActual(p.getStock().getCantidadActual());
			retorno.setCantidadCritica(p.getStock().getCantidadCritica());
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return retorno;
	}

	@Override
	public ProductoDTO updateOne(ProductoDTO dto, long id) throws Exception {
		ProductoDTO retorno = null;
		Producto aux = rP.findProductoWithStockById(id);			
		
		try {
			aux.setNombre(dto.getNombre());
			aux.setActivo(dto.isActivo());
			aux.setDescripcion(dto.getDescripcion());
			aux.setPrecio(dto.getPrecio());
			aux.getStock().setCantidadActual(dto.getCantidadActual());
			aux.getStock().setCantidadCritica(dto.getCantidadCritica());
			
			rP.save(aux);
			
			retorno = mM.map(aux, ProductoDTO.class);
			retorno.setCantidadActual(aux.getStock().getCantidadActual());
			retorno.setCantidadCritica(aux.getStock().getCantidadCritica());
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return retorno;
	}

	@Override
	public List<ProductoDTO> findAllbyActivo() {
		List<Producto> productos = rP.findAll();
		List<ProductoDTO> productosDTOs = new ArrayList<>();
		
		ProductoDTO aux;
		for(Producto p :productos) {
			aux = mM.map(p, ProductoDTO.class);
			aux.setCantidadActual(p.getStock().getCantidadActual());
			aux.setCantidadCritica(p.getStock().getCantidadCritica());
			
			if(aux.isActivo())
				productosDTOs.add(aux);
			
		}
		
		return productosDTOs;
	}

}
