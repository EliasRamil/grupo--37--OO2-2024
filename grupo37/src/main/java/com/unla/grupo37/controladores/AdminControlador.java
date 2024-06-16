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
	
	private String permisoVista() {
		String r = "error/403";
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
	    if (principal instanceof UserDetails) {
	        if(((UserDetails) principal).getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROL_ADMIN")))
	        	r = "Ok";
	    }
		
		return r;
	}
	
	@GetMapping("")
	public ModelAndView index() {
		String aux = permisoVista();
		
		if(aux.equals("Ok"))
			aux = AyudanteRutasVistas.ADMIN_INDEX;
		
		return new ModelAndView(aux);
	}

	@GetMapping("/pedido")
    public String pedido() {
		String aux = permisoVista();
		
		if(aux.equals("Ok"))
			aux = AyudanteRutasVistas.ADMIN_PEDIDO;
		
        return aux;
    }
	
	@GetMapping("/lote")
    public String lote() {
		String aux = permisoVista();
		
		if(aux.equals("Ok"))
			aux = AyudanteRutasVistas.ADMIN_LOTE;
		
        return aux;
    }
	
}
