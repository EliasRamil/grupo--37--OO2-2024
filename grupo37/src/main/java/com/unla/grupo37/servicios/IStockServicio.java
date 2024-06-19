package com.unla.grupo37.servicios;

import com.unla.grupo37.dtos.StockDTO;
import com.unla.grupo37.entidades.Compra;
import com.unla.grupo37.entidades.Lote;

public interface IStockServicio extends IServicioGenerico<StockDTO> {
	
	boolean actualizarStock(Lote lot);
	boolean actualizarStock(Compra com) throws Exception;
	
}
