package com.unla.grupo37.servicios.implementacion;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.unla.grupo37.dtos.ProductoDTO;
import com.unla.grupo37.entidades.Producto;
import com.unla.grupo37.repositorios.IProductoRepositorio;
import com.unla.grupo37.servicios.IProductoServicio;

@Service("productoServicio")
public class ProductoServicio implements IProductoServicio {

	private IProductoRepositorio repo;
	private ModelMapper mm = new ModelMapper();
	
	public ProductoServicio (IProductoRepositorio newrepo) {
		this.repo = newrepo;
	}

	@Override
	public List<Producto> getAll() {
		return repo.findAll();
	}

	@Override
	public ProductoDTO insertOrUpdate(ProductoDTO pDTO) {
		Producto p = repo.save(mm.map(pDTO, Producto.class));
		return mm.map(p, ProductoDTO.class);
	}

	@Override
	public boolean disable(int id) {
		try {
			repo.disableByID(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
