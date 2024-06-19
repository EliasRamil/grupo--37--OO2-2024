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
@RequestMapping("/admin/pedido")
public class AdminPedidoControlador {
	
	private IPedidoServicio pedidoServicio;
	private IProductoServicio productoServicio;
	private UsuarioRolServicio usuarioRolServicio;
	private UsuarioServicio u;
	
	public AdminPedidoControlador(IPedidoServicio pedidoServicio, IProductoServicio productoServicio, UsuarioRolServicio usuarioRolServicio, UsuarioServicio u) {
		this.pedidoServicio = pedidoServicio;
		this.productoServicio = productoServicio;
		this.usuarioRolServicio = usuarioRolServicio;
		this.u = u;
	}

	@GetMapping("")
    public ModelAndView pedido() {
		String aux = com.unla.grupo37.controladores.PermisosDeVista.getInstancia().permisoVista("ROL_ADMIN");
		ModelAndView mav = null;
		
		if (aux.equals("Ok")) {
			mav = new ModelAndView(AyudanteRutasVistas.ADMIN_PEDIDO);
			
			List<ProductoDTO> listaProductos= productoServicio.findAllbyActivo();
			mav.addObject("productos", listaProductos);
		} else {
			mav = new ModelAndView(aux);
		}
		
        return mav;
    }
	@PostMapping("{id}")
	public ModelAndView realizarPedido(@RequestParam String cantidad, @RequestParam String proveedor, @PathVariable(value="id") String id) throws Exception {
		int idCliente = 0;

	    // Obtener el nombre de usuario del usuario autenticado
	    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
	    if (principal instanceof UserDetails) {
	        String username = ((UserDetails) principal).getUsername();
	        
	        idCliente = (u.traerUsuario(username)).getId();
	    }
	    
	    Pedido pedido = new Pedido(proveedor, Integer.parseInt(cantidad), productoServicio.findByIdProducto(Integer.parseInt(id)),
		usuarioRolServicio.getClienteById(idCliente), null);
	    pedidoServicio.saveOne(pedido);
		
		return pedido(); // ;)
	}
}
