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
@RequestMapping("/admin/lote")
public class AdminLoteControlador extends AbstractAdminVista {
	
	private IPedidoServicio pedidoServicio;
	private IProductoServicio productoServicio;
	private UsuarioRolServicio usuarioRolServicio;
	private UsuarioServicio u;
	
	public AdminLoteControlador(IPedidoServicio pedidoServicio, IProductoServicio productoServicio, UsuarioRolServicio usuarioRolServicio, UsuarioServicio u) {
		this.pedidoServicio = pedidoServicio;
		this.productoServicio = productoServicio;
		this.usuarioRolServicio = usuarioRolServicio;
		this.u = u;
	}

	@GetMapping("")
    public ModelAndView lote() {
		String aux = permisoVista();
		
		if (!aux.equals("Ok")) return new ModelAndView(aux); // NUH UH
		
		ModelAndView mAV = new ModelAndView(AyudanteRutasVistas.ADMIN_LOTE);
		List<Pedido> listaPedidos = pedidoServicio.findAll(); // TODO Usar DTOs
		mAV.addObject("pedidos", listaPedidos);
		
        return mAV;
    }
	@PostMapping("{id}")
	//public ModelAndView realizarPedido(@RequestParam String cantidad, @RequestParam String proveedor, @PathVariable(value="id") String id) throws Exception {
	public ModelAndView realizarPedido() throws Exception {
		int idCliente = 0;

	    // Obtener el nombre de usuario del usuario autenticado
	    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
	    if (principal instanceof UserDetails) {
	        String username = ((UserDetails) principal).getUsername();
	        
	        idCliente = (u.traerUsuario(username)).getId();
	    }
	    
	    //Pedido pedido = new Pedido(proveedor, Integer.parseInt(cantidad), productoServicio.findByIdProducto(Integer.parseInt(id)),
		//usuarioRolServicio.getClienteById(idCliente), null);
	    //pedidoServicio.saveOne(pedido);
		
		return lote();
	}
	
}
