package com.unla.grupo37.controladores;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class PermisosDeVista {
	
	private static final PermisosDeVista instancia = new PermisosDeVista();
	
	private PermisosDeVista() {};
	
	public static PermisosDeVista getInstancia() {
		return instancia;
	}
	
	public String permisoVista() {
		String r = "error/403";
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
	    if (principal instanceof UserDetails) {
	        if(((UserDetails) principal).getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROL_ADMIN")))
	        	r = "Ok";
	    }
		
		return r;
	}
	
}
