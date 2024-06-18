package com.unla.grupo37.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo37.dtos.ProductoDTO;
import com.unla.grupo37.servicios.IProductoServicio;

@Controller
@RequestMapping("/admin/informes/productos-inventario")
public class AdminInformeInventarioControlador {

	private IProductoServicio p;

	public AdminInformeInventarioControlador(IProductoServicio p) {
		super();
		this.p = p;
	}
	
	@GetMapping("")
	public ModelAndView inventario() {
		String aux = com.unla.grupo37.controladores.PermisosDeVista.getInstancia().permisoVista();
		ModelAndView m = new ModelAndView(aux);
		
		if(aux.equals("Ok")) {
			m.setViewName(com.unla.grupo37.ayudante.AyudanteRutasVistas.ADMIN_INFORMES_INVENTARIO);
			
			List<ProductoDTO> lista = p.findAll();
			
			m.addObject("productos", lista);
			
		}
		
		
		return m;
	}
}
