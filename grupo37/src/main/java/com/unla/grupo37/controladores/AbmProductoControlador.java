package com.unla.grupo37.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo37.dtos.ProductoDTO;
import com.unla.grupo37.servicios.IProductoServicio;

@Controller
@RequestMapping("/admin/abm")
public class AbmProductoControlador {
	
	private IProductoServicio pS;

	public AbmProductoControlador(IProductoServicio pS) {
		this.pS = pS;
	}
	
	@GetMapping("")
	public ModelAndView opciones() {
		String aux = com.unla.grupo37.controladores.PermisosDeVista.getInstancia().permisoVista("ROL_ADMIN");
		ModelAndView m = new ModelAndView(aux);
		
		if(aux.equals("Ok")) {
			m.setViewName(com.unla.grupo37.ayudante.AyudanteRutasVistas.ADMIN_ABM);
			List<ProductoDTO> listaProductos= pS.findAll();
			m.addObject("productos", listaProductos);
		}
		
		return m;
	}
	
	@GetMapping("/crear")
	public ModelAndView crearGET() {
		String aux = com.unla.grupo37.controladores.PermisosDeVista.getInstancia().permisoVista("ROL_ADMIN");
		ModelAndView m = new ModelAndView(aux);
		
		if(aux.equals("Ok")){
			m.setViewName(com.unla.grupo37.ayudante.AyudanteRutasVistas.ADMIN_ALTA);
			m.addObject("producto", new ProductoDTO());
		}

		return m;
	}
	
	@PostMapping("/crear")
	public String crearPOST(@ModelAttribute("producto") ProductoDTO producto) throws Exception {
		
		try {
	        pS.saveOne(producto);
	    } catch (Exception e) {
	    	throw new Exception(e.getMessage());
	    }
		
		return com.unla.grupo37.ayudante.AyudanteRutasVistas.ADMIN_ABM_ROOT;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView actualizarGET(@PathVariable Long id) {
		String aux = com.unla.grupo37.controladores.PermisosDeVista.getInstancia().permisoVista("ROL_ADMIN");
		ModelAndView m = new ModelAndView(aux);
		
		if(aux.equals("Ok")){
			m.setViewName(com.unla.grupo37.ayudante.AyudanteRutasVistas.ADMIN_MODIFICACION);
			m.addObject("producto", new ProductoDTO());
			
			try {
				ProductoDTO p = pS.findById(id);
				m.addObject("producto", p);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}	

		return m;
	}
	
	@PostMapping("/editar/{id}")
	public String actualizarPOST(@ModelAttribute("producto") ProductoDTO producto, @PathVariable Long id) {
		
		try {
	        pS.updateOne(producto, id);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return com.unla.grupo37.ayudante.AyudanteRutasVistas.ADMIN_ABM_ROOT;
	}
	
}
