package com.unla.grupo37.servicios;

import java.util.List;

public interface IServicioGenerico<E> {
	List<E> findAll() throws Exception;
    E findById(long id) throws Exception;
    E saveOne(E entity) throws Exception;
    E updateOne(E entity, long id) throws Exception;
    boolean deleteById(long id) throws Exception;
}
