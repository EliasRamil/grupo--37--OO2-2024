package com.unla.grupo37.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo37.dtos.ProductoDTO;
import com.unla.grupo37.servicios.IProductoServicio;

@Controller
@RequestMapping("/admin/abm")
public class AbmProducto {
	
	private IProductoServicio pS;

	public AbmProducto(IProductoServicio pS) {
		this.pS = pS;
	}
	
	@GetMapping("")
	public ModelAndView opciones() {
		String aux = com.unla.grupo37.controladores.PermisosDeVista.getInstancia().permisoVista();
		ModelAndView m = new ModelAndView(aux);
		
		if(aux.equals("Ok")) {
			m.setViewName(com.unla.grupo37.ayudante.AyudanteRutasVistas.ADMIN_ABM);
			List<ProductoDTO> listaProductos= pS.findAll();
			m.addObject("productos", listaProductos);
		}
		
		return m;
	}
	
	@PostMapping("/crear")
	public String crear(@ModelAttribute("producto") ProductoDTO producto) {
		/*String aux = com.unla.grupo37.controladores.PermisosDeVista.getInstancia().permisoVista();
		
		if(aux.equals("Ok"))
			aux = com.unla.grupo37.ayudante.AyudanteRutasVistas.ADMIN_ALTA;
		
		pS.saveOne(producto);
		
		return com.unla.grupo37.ayudante.AyudanteRutasVistas.ADMIN_ABM;*/
		
		try {
	        pS.saveOne(producto);
	        return "redirect:/admin/abm"; // Redirigir a la página de administración después de crear el producto
	    } catch (Exception e) {
	        // Manejo de excepciones
	        // Puedes mostrar un mensaje de error o redirigir a una página de error
	        return "redirect:/error/500";
	    }
		
		
	}
	
	
}
