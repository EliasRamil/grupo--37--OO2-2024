package com.unla.grupo37.servicios;

import java.util.List;

import com.unla.grupo37.dtos.LoteDTO;
import com.unla.grupo37.dtos.PedidoDTO;
import com.unla.grupo37.entidades.Lote;
import com.unla.grupo37.entidades.Pedido;

public interface ILoteServicio extends IServicioGenerico<LoteDTO> {
	
	boolean nuevoLoteDesdePedido(Pedido pd) throws Exception;
	
}
