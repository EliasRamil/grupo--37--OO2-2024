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
import com.unla.grupo37.servicios.IServicioGenerico;

@Service
@Transactional
public class PedidoServicio implements IServicioGenerico<PedidoDTO> {
	
	@Autowired
	private IPedidoRepositorio r;
	private ModelMapper mM = new ModelMapper();

	@Override
	public List<PedidoDTO> findAll() {
		List<Pedido> pedidos = r.findAll(); // Obtener todos los registros de Pedido del repositorio
	    List<PedidoDTO> PedidoDTOs = new ArrayList<>();

	    for (Pedido pedido : pedidos) {
	        PedidoDTO PedidoDTO = mM.map(pedido, PedidoDTO.class); // Mapear cada Pedido a un PedidoDTO
	        PedidoDTOs.add(PedidoDTO);
	    }

	    return PedidoDTOs;
	}

	@Override
	public PedidoDTO findById(long id) throws Exception {
		Pedido aux = r.findById(id).orElse(null);
		
		if(aux == null)
			throw new Exception("No existe Pedido con el id: " + id);
		
		return mM.map(aux, PedidoDTO.class);
	}

	@Override
	public PedidoDTO saveOne(PedidoDTO dto) throws Exception {
		PedidoDTO retorno = null;
		
		try {
			Pedido s = r.save(mM.map(dto, Pedido.class));
			retorno = mM.map(s, PedidoDTO.class);
		} catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		
		return retorno;
	}

	@Override
	public PedidoDTO updateOne(PedidoDTO dto, long id) throws Exception {
		PedidoDTO retorno = null;
		
		try {
			PedidoDTO aux = this.findById(id);
			Pedido s = mM.map(aux, Pedido.class);
			s = r.save(mM.map(dto, Pedido.class));
			retorno = mM.map(s, PedidoDTO.class);
		} catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		
		return retorno;
	}

	@Override
	public boolean deleteById(long id) throws Exception {
		//Se realiza de esta forma porque en el Pedido no se tienen que eliminar elementos.
		throw new Exception("No se puede eliminar el Pedido");
	}
	
}
