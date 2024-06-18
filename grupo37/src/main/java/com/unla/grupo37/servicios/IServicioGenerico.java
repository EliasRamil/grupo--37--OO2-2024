package com.unla.grupo37.servicios;

import java.util.List;

public interface IServicioGenerico<E> {
	List<E> findAll();
    E findById(long id) throws Exception;
    E saveOne(E dto) throws Exception;
    E updateOne(E dto, long id) throws Exception;
}
