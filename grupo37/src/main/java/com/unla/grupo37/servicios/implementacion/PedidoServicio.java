package com.unla.grupo37.servicios.implementacion;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unla.grupo37.dtos.PedidoDTO;
import com.unla.grupo37.entidades.Pedido;
import com.unla.grupo37.repositorios.IPedidoRepositorio;
import com.unla.grupo37.servicios.IPedidoServicio;

@Service
@Transactional
public class PedidoServicio implements IPedidoServicio {
	
	@Autowired
	private IPedidoRepositorio repo;
	private static ModelMapper mm = new ModelMapper();
	
	static {
		mm.createTypeMap(Pedido.class, PedidoDTO.class)
				.addMapping(Pedido::getId, PedidoDTO::setId)
				.addMapping(Pedido::getCantidadPedida, PedidoDTO::setCantidadPedida)
				.addMapping(Pedido::getProveedor, PedidoDTO::setProveedor)
				.addMapping(src -> src.getProducto().getNombre(), PedidoDTO::setNombreProducto)
				.addMapping(src -> src.getAdmin().getNombreDeUsuario(), PedidoDTO::setNombreAdmin)		
			;
	}

	@Override
	public List<Pedido> findAll() {
	    return repo.findAll(); // Obtener todos los registros de Pedido del repositorio
	}
	@Override
	public List<PedidoDTO> findAllSimple(boolean soloSinProcesar) {
		//List<Pedido> todo = findAll();
		List<Pedido> todo;
		
		if (soloSinProcesar) todo = repo.getAllUnprocessedPedidosWithDetails();
		else todo = repo.getAllPedidosWithDetails();
		
		List<PedidoDTO> todoDTO = new ArrayList<PedidoDTO>();
		for (Pedido pd : todo) {
			//if (soloSinProcesar) if (pd.isProcesado()) continue;
			todoDTO.add(mm.map(pd, PedidoDTO.class));
		}
		
		return todoDTO;
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
	
	@Override
	public Pedido updateOne(Pedido pd, long id) throws Exception {
		try {
			Pedido aux = repo.findById(id).orElse(null);
			if (aux==null) throw new Exception("No existe Pedido con ID " + id);
			
			pd = repo.save(pd);
		} catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		
		return pd;
	}
	
}
