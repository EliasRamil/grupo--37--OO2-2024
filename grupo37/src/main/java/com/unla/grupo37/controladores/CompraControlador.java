package com.unla.grupo37.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.unla.grupo37.repositorios.IUsuarioRepositorio;
import com.unla.grupo37.servicios.IProductoServicio;
import com.unla.grupo37.servicios.implementacion.CompraServicio;
import com.unla.grupo37.servicios.implementacion.UsuarioRolServicio;

@Controller
@RequestMapping("/compra")
public class CompraControlador {
	
	private CompraServicio compraServicio;
	private IProductoServicio productoServicio;
	private UsuarioRolServicio usuarioRolServicio;
	@Autowired
	private IUsuarioRepositorio u;
	
	public CompraControlador(CompraServicio compraServicio, IProductoServicio productoServicio, UsuarioRolServicio usuarioRolServicio) {
		this.compraServicio= compraServicio;
		this.productoServicio= productoServicio;
		this.usuarioRolServicio=usuarioRolServicio;
	}
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(AyudanteRutasVistas.COMPRA_INDEX);
		List<ProductoDTO> listaProductos= productoServicio.findAllbyActivo();
		mAV.addObject("productos", listaProductos);
		
		return mAV;
	}
	
	
	@PostMapping("{id}")
	public String finalizarCompra(@RequestParam String cantidad, @PathVariable(value="id") String id) throws Exception {
		int idCliente = 0; // Inicializar el ID del cliente

	    // Obtener el nombre de usuario del usuario autenticado
	    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    
	    if (principal instanceof UserDetails) {
	        String username = ((UserDetails) principal).getUsername();
	        
	        idCliente = (u.findByNombreDeUsuarioAndFetchRolesDeUsuarioEagerly(username)).getId();
	    }
		
		Compra compra= new Compra(Integer.parseInt(cantidad), productoServicio.findByIdProducto(Integer.parseInt(id)),
				usuarioRolServicio.getClienteById(idCliente));
		compraServicio.saveOne(compra);
		
		return AyudanteRutasVistas.COMPRA_ROOT;
	}
	
}
