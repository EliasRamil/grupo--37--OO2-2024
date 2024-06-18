package com.unla.grupo37.servicios.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unla.grupo37.dtos.ProductoDTO;
import com.unla.grupo37.entidades.Compra;
import com.unla.grupo37.repositorios.ICompraRepositorio;
import com.unla.grupo37.servicios.ICompraServicio;
import com.unla.grupo37.servicios.IProductoServicio;

import jakarta.transaction.Transactional;

@Service
public class CompraServicio implements ICompraServicio {
	
	private ICompraRepositorio repositorioCompra;
	private IProductoServicio productoServicio;
	
	public CompraServicio(ICompraRepositorio repositorioCompra, ProductoServicio productoServicio) {
		this.repositorioCompra= repositorioCompra;
		this.productoServicio= productoServicio;
	}

	
	@Override
	@Transactional
	public List<Compra> findAll(){
		
		List<Compra> entities= this.repositorioCompra.findAll();
		return entities;
		
	}
	
	@Override
	@Transactional
	public Compra findById(long id) throws Exception{
		try {
			Optional<Compra> opt= this.repositorioCompra.findById(id);
			return opt.get();
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	@Transactional
	public Compra saveOne(Compra entity) throws Exception{
		try {
			Compra compra= this.repositorioCompra.save(entity);
			ProductoDTO producto= productoServicio.findById(compra.getProducto().getId());
			producto.setCantidadActual(producto.getCantidadActual() -compra.getCantidadComprada());
			productoServicio.updateOne(producto, producto.getId());
			return compra;
			
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	@Transactional
	public Compra updateOne(Compra entity, long id)throws Exception{
		try {
			Optional<Compra> opt= this.repositorioCompra.findById(id);
			Compra compra= opt.get();
			compra=this.repositorioCompra.save(entity);
			return compra;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/*@Override
	@Transactional
	public boolean deleteById(long id)throws Exception{
		try {
			Optional<Compra> opt= this.repositorioCompra.findById(id);
			if(! opt.isEmpty()) {
				Compra compra= opt.get();
				this.repositorioCompra.delete(compra);
			}else {
				throw new Exception("error al borrar");
			}
			
			return true;
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}*/
	
	
	
}
