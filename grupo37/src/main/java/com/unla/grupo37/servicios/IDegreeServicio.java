package com.unla.grupo37.servicios;

import java.util.List;

import com.unla.grupo37.dtos.DegreeDTO;
import com.unla.grupo37.entidades.Degree;

public interface IDegreeServicio {

	public List<Degree> getAll();
	public DegreeDTO insertOrUpdate(DegreeDTO dDTO);
	public boolean remove(int id);
	
}
