package com.unla.grupo37.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo37.ayudante.AyudanteRutasVistas;

@Controller
@RequestMapping("/admin")
public class AdminControlador {
	
	public AdminControlador() {	}
	
	//@GetMapping("")
	@GetMapping(value={"", "index.html"})
	public ModelAndView index() {
		String aux = com.unla.grupo37.controladores.PermisosDeVista.getInstancia().permisoVista();
		
		if(aux.equals("Ok"))
			aux = AyudanteRutasVistas.ADMIN_INDEX;
		
		return new ModelAndView(aux);
	}
	
}
