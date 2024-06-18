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
		
		if(rP.findProductosByNombre(dto.getNombre()).size() != 0)
			throw new Exception("Ya existe un producto con el nombre" + dto.getNombre());
		
		try {
			Producto p = mM.map(dto, Producto.class);
			p.setStock(new Stock(dto.getCantidadActual(), dto.getCantidadCritica()));
			rP.save(p);
			retorno = mM.map(p, ProductoDTO.class);
			retorno.setCantidadActual(p.getStock().getCantidadActual());
			retorno.setCantidadCritica(p.getStock().getCantidadCritica());
		} catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		
		return retorno;
	}

	@Override
	public ProductoDTO updateOne(ProductoDTO dto, long id) throws Exception {
		Producto aux = rP.findProductoWithStockById(id);
		
		if(aux == null)
			throw new Exception("No existe el Producto con el id: " + id);
		
		Producto p = mM.map(aux, Producto.class);
		p.getStock().setCantidadCritica(dto.getCantidadCritica());
		
		if(rP.findProductosByNombre(dto.getNombre()).size() > 1)
			throw new Exception("Ya existe otro producto con el nombre" + dto.getNombre());
		
		rP.save(p);
		
		ProductoDTO retorno = mM.map(p, ProductoDTO.class);
		retorno.setCantidadActual(p.getStock().getCantidadActual());
		retorno.setCantidadCritica(p.getStock().getCantidadCritica());
		
		return retorno;
	}

	@Override
	public boolean deleteById(long id) throws Exception {
		Producto p = rP.findById(id).orElse(null);
		
		if(p == null)
			throw new Exception("No existe el Producto con el id: " + id);
		
		p.setActivo(false);
		
		return true;
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
