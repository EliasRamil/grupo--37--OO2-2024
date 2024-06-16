package com.unla.grupo37.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo37.ayudante.AyudanteRutasVistas;

@Controller
@RequestMapping("/admin")
public class AdminControlador {
	
	@GetMapping("")
	public ModelAndView index() {
		return new ModelAndView(AyudanteRutasVistas.ADMIN_INDEX);
	}

}
