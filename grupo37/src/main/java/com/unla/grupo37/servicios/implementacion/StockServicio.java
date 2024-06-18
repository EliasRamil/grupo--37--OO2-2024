package com.unla.grupo37.servicios.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unla.grupo37.dtos.StockDTO;
import com.unla.grupo37.entidades.Compra;
import com.unla.grupo37.entidades.Lote;
import com.unla.grupo37.entidades.Stock;
import com.unla.grupo37.repositorios.IStockRepositorio;
import com.unla.grupo37.servicios.IServicioGenerico;
import com.unla.grupo37.servicios.IStockServicio;

@Service
@Transactional
public class StockServicio implements IStockServicio {
	
	@Autowired
	private IStockRepositorio r;
	private ModelMapper mM = new ModelMapper();

	@Override
	public List<StockDTO> findAll() {
		List<Stock> stocks = r.findAll(); // Obtener todos los registros de Stock del repositorio
	    List<StockDTO> stockDTOs = new ArrayList<>();

	    for (Stock stock : stocks) {
	        StockDTO stockDTO = mM.map(stock, StockDTO.class); // Mapear cada Stock a un StockDTO
	        stockDTOs.add(stockDTO);
	    }

	    return stockDTOs;
	}

	@Override
	public StockDTO findById(long id) throws Exception {
		Stock aux = r.findById(id).orElse(null);
		
		if(aux == null)
			throw new Exception("No existe Stock con el id: " + id);
		
		return mM.map(aux, StockDTO.class);
	}

	@Override
	public StockDTO saveOne(StockDTO dto) throws Exception {
		StockDTO retorno = null;
		
		try {
			Stock s = r.save(mM.map(dto, Stock.class));
			retorno = mM.map(s, StockDTO.class);
		} catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		
		return retorno;
	}

	@Override
	public StockDTO updateOne(StockDTO dto, long id) throws Exception {
		StockDTO retorno = null;
		
		try {
			StockDTO aux = this.findById(id);
			Stock s = mM.map(aux, Stock.class);
			s = r.save(mM.map(dto, Stock.class));
			retorno = mM.map(s, StockDTO.class);
		} catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		
		return retorno;
	}

	/*@Override
	public boolean deleteById(long id) throws Exception {
		//Se realiza de esta forma porque en el Stock no se tienen que eliminar elementos.
		throw new Exception("No se puede eliminar el Stock");
	}*/
	
	/**
	 * En base a un <code>Lote</code>, obtiene el <code>Stock</code> del producto y actualiza la cantidad.
	 * @param lot El <code>Lote</code> con la cantidad de producto recibido.
	 * @return Un booleano que indica si la accion fue exitosa.
	 */
	public boolean actualizarStock(Lote lot) {
		Stock sk = lot.getProducto().getStock();
		
		sk.setCantidadActual(sk.getCantidadActual() + lot.getCantidadRecibida());
		r.save(sk);
		
		return true;
	}
	
	/**
	 * En base a un <code>Lote</code>, obtiene el <code>Stock</code> del producto y actualiza la cantidad.
	 * @param lot El <code>Lote</code> con la cantidad de producto recibido.
	 * @return Un booleano que indica si la accion fue exitosa.
	 * @throws Exception si la compra excede el stock disponible.
	 */
	public boolean actualizarStock(Compra com) throws Exception {
		Stock sk = com.getProducto().getStock();
		
		int diff = sk.getCantidadActual() - com.getCantidadComprada();
		if (diff < 0) throw new Exception("La cantidad comprada excede la cantidad en stock");
		//Stock sk = lot.getProducto().getStock();
		sk.setCantidadActual(diff);
		r.save(sk);
		
		return true;
	}
	
}
