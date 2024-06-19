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
import com.unla.grupo37.dtos.ProductoDTO;
import com.unla.grupo37.entidades.Compra;
import com.unla.grupo37.servicios.ICompraServicio;
import com.unla.grupo37.servicios.IProductoServicio;
import com.unla.grupo37.servicios.implementacion.UsuarioRolServicio;
import com.unla.grupo37.servicios.implementacion.UsuarioServicio;

@Controller
@RequestMapping("/compra")
public class CompraControlador {
	
	private ICompraServicio compraServicio;
	private IProductoServicio productoServicio;
	private UsuarioRolServicio usuarioRolServicio;
	private UsuarioServicio u;
	
	public CompraControlador(ICompraServicio compraServicio, IProductoServicio productoServicio, UsuarioRolServicio usuarioRolServicio, UsuarioServicio u) {
		this.compraServicio= compraServicio;
		this.productoServicio= productoServicio;
		this.usuarioRolServicio=usuarioRolServicio;
		this.u = u;
	}
	
	@GetMapping("")
	public ModelAndView index() {
		String aux = com.unla.grupo37.controladores.PermisosDeVista.getInstancia().permisoVista("ROL_USUARIO");
		ModelAndView mAV = new ModelAndView(aux);
		
		if(aux.equals("Ok")) {
			mAV.setViewName(com.unla.grupo37.ayudante.AyudanteRutasVistas.COMPRA_INDEX);
			List<ProductoDTO> listaProductos= productoServicio.findAllbyActivo();
			mAV.addObject("productos", listaProductos);
		}	
		
		return mAV;
	}
	
	
	@PostMapping("{id}")
	public String finalizarCompra(@RequestParam String cantidad, @PathVariable(value="id") String id) throws Exception {
		int idCliente = 0;

	    // Obtener el nombre de usuario del usuario autenticado
	    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
	    if (principal instanceof UserDetails) {
	        String username = ((UserDetails) principal).getUsername();
	        
	        idCliente = (u.traerUsuario(username)).getId();
	    }
		
		Compra compra= new Compra(Integer.parseInt(cantidad), productoServicio.findByIdProducto(Integer.parseInt(id)),
				usuarioRolServicio.getClienteById(idCliente));
		compraServicio.saveOne(compra);
		
		return AyudanteRutasVistas.COMPRA_ROOT;
	}
	
}
