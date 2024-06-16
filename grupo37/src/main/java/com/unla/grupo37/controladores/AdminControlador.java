package com.unla.grupo37.controladores;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
		String aux = "error/403";
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
	    if (principal instanceof UserDetails) {
	        if(((UserDetails) principal).getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROL_ADMIN")))
	        	aux = AyudanteRutasVistas.ADMIN_INDEX;
	    }
		
		return new ModelAndView(aux);
	}

	@GetMapping("/pedido")
    public String pedido() {
        return AyudanteRutasVistas.ADMIN_PEDIDO;
    }
	
	@GetMapping("/lote")
    public String lote() {
        return AyudanteRutasVistas.ADMIN_LOTE;
    }
	
}
