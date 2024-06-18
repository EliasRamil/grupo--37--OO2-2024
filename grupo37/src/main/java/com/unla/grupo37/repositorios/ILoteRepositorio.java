package com.unla.grupo37.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo37.dtos.LoteDTO;
import com.unla.grupo37.entidades.Lote;

@Repository
public interface ILoteRepositorio extends JpaRepository<Lote, Long> {
	
	@Query("FROM Lote lot INNER JOIN FETCH Producto prod ON lot.producto = prod WHERE prod.id = :id ORDER BY lot.fechaRecepcion DESC")
	List<Lote> findAllLotesOfProducto(@Param("id") Long id);
	
}
