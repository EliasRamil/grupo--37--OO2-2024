package com.unla.grupo37.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo37.ayudante.AyudanteRutasVistas;

@Controller
@RequestMapping("/admin/informes")
public class AdminInformeControlador {
	
	public AdminInformeControlador() {	}
	
	
	@GetMapping(value={"", "index.html"})
	public ModelAndView indexInformes() {
		String aux = com.unla.grupo37.controladores.PermisosDeVista.getInstancia().permisoVista("ROL_ADMIN");
		
		if(aux.equals("Ok"))
			aux = AyudanteRutasVistas.ADMIN_INFORMES_INDEX;
		
		return new ModelAndView(aux);
	}
	
}