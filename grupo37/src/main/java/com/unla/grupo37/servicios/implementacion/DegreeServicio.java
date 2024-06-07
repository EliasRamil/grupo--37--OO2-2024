package com.unla.grupo37.servicios.implementacion;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.unla.grupo37.dtos.DegreeDTO;
import com.unla.grupo37.entidades.Degree;
import com.unla.grupo37.repositorios.IDegreeRepositorio;
import com.unla.grupo37.servicios.IDegreeServicio;

@Service("degreeServicio")
public class DegreeServicio implements IDegreeServicio {

	private IDegreeRepositorio dR;
	private ModelMapper mM = new ModelMapper();
	
	public DegreeServicio (IDegreeRepositorio dR) {
		this.dR = dR;
	}

	@Override
	public List<Degree> getAll() {
		return dR.findAll();
	}

	@Override
	public DegreeDTO insertOrUpdate(DegreeDTO dDTO) {
		Degree d = dR.save(mM.map(dDTO, Degree.class));
		return mM.map(d, DegreeDTO.class);
	}

	@Override
	public boolean remove(int id) {
		try {
			dR.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
}
