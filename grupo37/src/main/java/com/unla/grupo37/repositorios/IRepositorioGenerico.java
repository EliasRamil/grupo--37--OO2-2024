package com.unla.grupo37.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorioGenerico<E> extends JpaRepository<E, Long> {

}
