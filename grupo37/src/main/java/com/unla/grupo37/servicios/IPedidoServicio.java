package com.unla.grupo37.servicios;

import java.util.List;

import com.unla.grupo37.dtos.PedidoDTO;
import com.unla.grupo37.entidades.Pedido;

public interface IPedidoServicio extends IServicioGenerico<Pedido> {
	
	List<PedidoDTO> findAllSimple();
	
}
