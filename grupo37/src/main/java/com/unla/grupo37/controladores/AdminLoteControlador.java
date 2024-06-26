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
import com.unla.grupo37.entidades.Lote;
import com.unla.grupo37.entidades.Pedido;
import com.unla.grupo37.servicios.ILoteServicio;
import com.unla.grupo37.servicios.IPedidoServicio;
import com.unla.grupo37.servicios.IStockServicio;
import com.unla.grupo37.servicios.implementacion.UsuarioRolServicio;
import com.unla.grupo37.servicios.implementacion.UsuarioServicio;

@Controller
@RequestMapping("/admin/lote")
public class AdminLoteControlador {
	
	private IPedidoServicio pedidoServicio;
	private ILoteServicio loteServicio;
	private UsuarioServicio u;
	private IStockServicio stockServicio;
	
	public AdminLoteControlador(IPedidoServicio pedidoServicio, ILoteServicio loteServicio, IStockServicio stockServicio, UsuarioRolServicio usuarioRolServicio, UsuarioServicio u) {
		this.pedidoServicio = pedidoServicio;
		this.loteServicio = loteServicio;
		this.stockServicio = stockServicio;
		this.u = u;
	}

	@GetMapping("")
    public ModelAndView lote() {
		String aux = com.unla.grupo37.controladores.PermisosDeVista.getInstancia().permisoVista("ROL_ADMIN");
		ModelAndView mav = null;
		
		if (aux.equals("Ok")) {
			mav = new ModelAndView(AyudanteRutasVistas.ADMIN_LOTE);
			
			List<PedidoDTO> listaPedidos = pedidoServicio.findAllSimple(true);
			mav.addObject("pedidosDTO", listaPedidos);
		} else {
			mav = new ModelAndView(aux); // NUH UH
		}
		
        return mav;
    }
	
	@PostMapping("{id}")
	public String procesarPedido(@PathVariable(value="id") String idStr, @RequestParam(name = "precio") String precioStr) throws Exception {
	    
	    int id = Integer.parseInt(idStr);
	    double precio = Double.parseDouble(precioStr);
	    
	    Pedido pd = pedidoServicio.findById(id);
	    if (pd == null) throw new Exception("Pedido inexistente");
	    
	    Lote lot = loteServicio.nuevoLoteDesdePedido(pd, precio);
	    stockServicio.actualizarStock(lot);
		
		return com.unla.grupo37.ayudante.AyudanteRutasVistas.ADMIN_LOTE_ROOT;
	}
	
}
