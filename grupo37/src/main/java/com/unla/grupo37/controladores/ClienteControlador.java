package com.unla.grupo37.controladores;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.grupo37.servicios.implementacion.UsuarioRolServicio;

@Controller
@PreAuthorize("hasRole('ROL_USUARIO')")
@RequestMapping("/cliente")
public class ClienteControlador {
	private UsuarioRolServicio usuarioRolServicio;
	
	
	
	
	

}
