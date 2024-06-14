package com.unla.grupo37.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo37.entidades.Lote;

@Repository
public interface ILoteRepositorio extends JpaRepository<Lote, Long> {

}
