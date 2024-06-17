package com.unla.grupo37.controladores;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo37.ayudante.AyudanteRutasVistas;
import com.unla.grupo37.dtos.PedidoDTO;
import com.unla.grupo37.dtos.ProductoDTO;
import com.unla.grupo37.entidades.Pedido;
import com.unla.grupo37.servicios.IPedidoServicio;
import com.unla.grupo37.servicios.IProductoServicio;
import com.unla.grupo37.servicios.IServicioGenerico;
import com.unla.grupo37.servicios.implementacion.UsuarioRolServicio;
import com.unla.grupo37.servicios.implementacion.UsuarioServicio;

@Controller
@RequestMapping("/admin")
public class AdminControlador {
	
	private IPedidoServicio pedidoServicio;
	private IProductoServicio productoServicio;
	private UsuarioRolServicio usuarioRolServicio;
	private UsuarioServicio u;
	
	public AdminControlador(IPedidoServicio pedidoServicio, IProductoServicio productoServicio, UsuarioRolServicio usuarioRolServicio, UsuarioServicio u) {
		this.pedidoServicio = pedidoServicio;
		this.productoServicio = productoServicio;
		this.usuarioRolServicio = usuarioRolServicio;
		this.u = u;
	}
	
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
}
