package com.unla.grupo37.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo37.ayudante.AyudanteRutasVistas;
import com.unla.grupo37.dtos.LoteDTO;
import com.unla.grupo37.dtos.ProductoDTO;
import com.unla.grupo37.entidades.Producto;
import com.unla.grupo37.servicios.ILoteServicio;
import com.unla.grupo37.servicios.IPedidoServicio;
import com.unla.grupo37.servicios.IProductoServicio;

@Controller
@RequestMapping("/admin/informes/lotes")
public class AdminInformeLotesControlador {
	
	private ILoteServicio loteServicio;
	private IProductoServicio productoServicio;
	
	public AdminInformeLotesControlador(IProductoServicio productoServicio, ILoteServicio loteServicio) {
		this.loteServicio = loteServicio;
		this.productoServicio = productoServicio;
	}
	
	//@GetMapping("")
	@GetMapping("")
	public ModelAndView informeLoteGET(@RequestParam(name="producto", required=false) String pdIDStr) {
		String aux = com.unla.grupo37.controladores.PermisosDeVista.getInstancia().permisoVista();
		
		boolean conPermiso = aux.equals("Ok");
		ModelAndView mav = null;
		
		if (conPermiso) {
			mav = new ModelAndView(AyudanteRutasVistas.ADMIN_INFORMES_LOTES);
			
			List<ProductoDTO> lista = productoServicio.findAllbyActivo();
			mav.addObject("prods", lista);
			
			if (pdIDStr != null) {
				Producto pd = null;
				int pdID = 0;
				
				try {
					pdID = Integer.parseInt(pdIDStr);
					pd = productoServicio.findByIdProducto(pdID);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (pd != null) {
					List<LoteDTO> lotelista = loteServicio.findLotesByProductoId(pd.getId());
					
					mav.addObject("currentID", pdID);
					mav.addObject("lotsDTO", lotelista);
				} else {
					mav.addObject("notvalid", true);
				}
			}
			// poner cosas
		} else {
			mav = new ModelAndView(aux);
		}
		
		return mav;
	}
	
}
