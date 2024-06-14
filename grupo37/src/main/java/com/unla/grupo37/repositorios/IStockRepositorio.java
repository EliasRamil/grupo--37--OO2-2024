package com.unla.grupo37.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo37.entidades.Stock;

@Repository
public interface IStockRepositorio extends JpaRepository<Stock, Long> {

}
