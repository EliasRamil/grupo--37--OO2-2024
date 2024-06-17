package com.unla.grupo37.servicios.implementacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unla.grupo37.dtos.LoteDTO;
import com.unla.grupo37.entidades.Lote;
import com.unla.grupo37.entidades.Pedido;
import com.unla.grupo37.entidades.Producto;
import com.unla.grupo37.entidades.Stock;
import com.unla.grupo37.repositorios.ILoteRepositorio;
import com.unla.grupo37.repositorios.IPedidoRepositorio;
import com.unla.grupo37.servicios.ILoteServicio;
import com.unla.grupo37.servicios.IPedidoServicio;
import com.unla.grupo37.servicios.IServicioGenerico;

@Service
@Transactional
public class LoteServicio implements ILoteServicio {
	
	// TODO No hay que usar DTOs
	
	@Autowired
	private ILoteRepositorio r;
	//private static IPedidoServicio pds = new PedidoServicio();
	private ModelMapper mM = new ModelMapper();

	@Override
	public List<LoteDTO> findAll() {
		List<Lote> lotes = r.findAll(); // Obtener todos los registros de Lote del repositorio
	    List<LoteDTO> loteDTOs = new ArrayList<>();

	    for (Lote lote : lotes) {
	        LoteDTO loteDTO = mM.map(lote, LoteDTO.class); // Mapear cada Lote a un LoteDTO
	        loteDTOs.add(loteDTO);
	    }

	    return loteDTOs;
	}

	@Override
	public LoteDTO findById(long id) throws Exception {
		Lote aux = r.findById(id).orElse(null);
		
		if(aux == null)
			throw new Exception("No existe Lote con el id: " + id);
		
		return mM.map(aux, LoteDTO.class);
	}

	@Override
	public LoteDTO saveOne(LoteDTO dto) throws Exception {
		LoteDTO retorno = null;
		
		try {
			Lote s = r.save(mM.map(dto, Lote.class));
			retorno = mM.map(s, LoteDTO.class);
		} catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		
		return retorno;
	}

	@Override
	public LoteDTO updateOne(LoteDTO dto, long id) throws Exception {
		LoteDTO retorno = null;
		
		try {
			LoteDTO aux = this.findById(id);
			Lote s = mM.map(aux, Lote.class);
			s = r.save(mM.map(dto, Lote.class));
			retorno = mM.map(s, LoteDTO.class);
		} catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		
		return retorno;
	}

	@Override
	public boolean deleteById(long id) throws Exception {
		//Se realiza de esta forma porque en el Lote no se tienen que eliminar elementos.
		throw new Exception("No se puede eliminar el Lote");
	}
	
	
	
	/**
	 * En base al <code>Pedido</code> dado, crea un <code>Lote</code> y modifica sus campos de acuerdo al pedido.
	 * @param pd El <code>Pedido</code> en cuestion.
	 * @return Un booleano que indica si el procesamiento fue exitoso.
	 * @throws Exception 
	 */
	public boolean nuevoLoteDesdePedido(Pedido pd) throws Exception {
		Lote lot = new Lote();
		
		lot.setPedido(pd);
		lot.setFechaRecepcion(LocalDateTime.now());
		lot.setCantidadRecibida(pd.getCantidadPedida());
		lot.setProducto(pd.getProducto());
		// TODO lot.setPrecioProducto(???);
		lot = r.save(lot);
		
		// TODO poner logica de pedido aca... como?
		
		return true;
	}
	
}
