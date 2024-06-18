package com.unla.grupo37.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo37.dtos.ProductoRankingDTO;
import com.unla.grupo37.servicios.IProductoRankingServicio;

@Controller
@RequestMapping("/admin/informes/rankingProducto")
public class AdminInformeRankingProductoControlador {

	private IProductoRankingServicio s;

	public AdminInformeRankingProductoControlador(IProductoRankingServicio s) {
		super();
		this.s = s;
	}
	
	@GetMapping("")
	public ModelAndView inventario() {
		String aux = com.unla.grupo37.controladores.PermisosDeVista.getInstancia().permisoVista();
		ModelAndView m = new ModelAndView(aux);
		
		if(aux.equals("Ok")) {
			m.setViewName(com.unla.grupo37.ayudante.AyudanteRutasVistas.ADMIN_INFORMES_RANKING_PRODUCTO);
			
			List<ProductoRankingDTO> lista = s.findAll();
			
			m.addObject("productos", lista);
			
		}
		
		
		return m;
	}
	
}
