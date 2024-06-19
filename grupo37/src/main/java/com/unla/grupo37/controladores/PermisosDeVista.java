package com.unla.grupo37.controladores;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class PermisosDeVista {
	
	private static final PermisosDeVista instancia = new PermisosDeVista();
	
	private PermisosDeVista() {};
	
	public static PermisosDeVista getInstancia() {
		return instancia;
	}
	
	public String permisoVista(String rol) {
		String r = com.unla.grupo37.ayudante.AyudanteRutasVistas.E_403;
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
	    if (principal instanceof UserDetails) {
	        if(((UserDetails) principal).getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals(rol)))
	        	r = "Ok";
	    }
		
		return r;
	}
	
}
