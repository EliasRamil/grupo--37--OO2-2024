package com.unla.grupo37.repositorios;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo37.entidades.Degree;

@Repository("degreeRepositorio")
public interface IDegreeRepositorio extends JpaRepository<Degree, Serializable> {

	public abstract Degree findByName(String name);
	public abstract Degree findByInstitutionAndYear(String institution, int year);
	public abstract List<Degree> findByInstitutionAndYearOrderByYearDesc(String institution, int year);
	
}
