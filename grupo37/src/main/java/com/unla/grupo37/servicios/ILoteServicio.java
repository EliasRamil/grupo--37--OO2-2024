package com.unla.grupo37.servicios;

import java.util.List;

import com.unla.grupo37.dtos.LoteDTO;
import com.unla.grupo37.dtos.PedidoDTO;
import com.unla.grupo37.entidades.Lote;
import com.unla.grupo37.entidades.Pedido;

public interface ILoteServicio extends IServicioGenerico<LoteDTO> {
	
	Lote nuevoLoteDesdePedido(Pedido pd, double precio) throws Exception;
	List<LoteDTO> findLotesByProductoId(long id);
	
}
