package com.unla.grupo37.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.unla.grupo37.dtos.ProductoDTO;
import com.unla.grupo37.entidades.Compra;
import com.unla.grupo37.servicios.IProductoServicio;
import com.unla.grupo37.servicios.implementacion.CompraServicio;
import com.unla.grupo37.servicios.implementacion.UsuarioRolServicio;

@Controller
@RequestMapping("/")
public class CompraControlador {
	
	private CompraServicio compraServicio;
	private IProductoServicio productoServicio;
	private UsuarioRolServicio usuarioRolServicio;
	
	public CompraControlador(CompraServicio compraServicio, IProductoServicio productoServicio, UsuarioRolServicio usuarioRolServicio) {
		this.compraServicio= compraServicio;
		this.productoServicio= productoServicio;
		this.usuarioRolServicio=usuarioRolServicio;
	}
	
	@GetMapping("/compra")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView("compra/ListaProductos");
		List<ProductoDTO> listaProductos= productoServicio.findAllbyActivo();
		mAV.addObject("productos", listaProductos);
		
		return mAV;
	}
	
	
	@PostMapping("{id}")
	public String finalizarCompra(@RequestParam String cantidad, @PathVariable(value="id") String id) throws Exception {
		
		
		Compra compra= new Compra(Integer.parseInt(cantidad), productoServicio.findByIdProducto(Integer.parseInt(id)),
				usuarioRolServicio.getClienteById(1));
		compraServicio.saveOne(compra);
		
		return "redirect:/compra";
		
	}
	
	

}
