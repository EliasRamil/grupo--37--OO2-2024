package com.unla.grupo37.servicios.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unla.grupo37.entidades.Compra;
import com.unla.grupo37.entidades.Pedido;
import com.unla.grupo37.repositorios.IPedidoRepositorio;
import com.unla.grupo37.servicios.IPedidoServicio;
import com.unla.grupo37.servicios.IServicioGenerico;

@Service
@Transactional
public class PedidoServicio implements IPedidoServicio {
	
	// TODO No hay que usar DTOs
	
	@Autowired
	private IPedidoRepositorio repo;
	//private ModelMapper mM = new ModelMapper();

	@Override
	public List<Pedido> findAll() {
	    return repo.findAll(); // Obtener todos los registros de Pedido del repositorio
	}

	@Override
	public Pedido findById(long id) throws Exception {
		Pedido pd = repo.findById(id).orElse(null);
		
		if (pd == null) throw new Exception("No existe Pedido con ID " + id);
		
		return pd;
	}

	@Override
	public Pedido saveOne(Pedido pd) throws Exception {
		try {
			pd = repo.save(pd);
		} catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		
		return pd;
	}
	
	// TODO long id???
	@Override
	public Pedido updateOne(Pedido pd, long id) throws Exception {
		try {
			Pedido aux = repo.findById(id).orElse(null); // TODO innecesario?
			if (aux==null) throw new Exception("No existe Pedido con ID " + id);
			
			pd = repo.save(pd);
		} catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		
		return pd;
	}

	@Override
	public boolean deleteById(long id) throws Exception {
		// TODO PedidoServicio.deleteById?
		throw new Exception("No se puede eliminar el Pedido");
		//return false;
	}
	
}
