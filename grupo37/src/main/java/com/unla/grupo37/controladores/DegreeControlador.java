package com.unla.grupo37.controladores;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo37.ayudante.AyudanteRutasVistas;
import com.unla.grupo37.dtos.DegreeDTO;
import com.unla.grupo37.servicios.IDegreeServicio;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/degrees")
public class DegreeControlador {
	private IDegreeServicio dS;
	
	public DegreeControlador (IDegreeServicio dS) {
		this.dS = dS;
	}
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(AyudanteRutasVistas.DEGREE_INDEX);
		mAV.addObject("degrees", dS.getAll());
		mAV.addObject("degree", new DegreeDTO());
		return mAV;
	}

	@PostMapping("/")
	public RedirectView create(@ModelAttribute("degree") DegreeDTO degreeDTO) {
		dS.insertOrUpdate(degreeDTO);
		return new RedirectView(AyudanteRutasVistas.DEGREE_ROOT);
	}
	
}
