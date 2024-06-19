package com.unla.grupo37.controladores;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo37.ayudante.AyudanteRutasVistas;
import com.unla.grupo37.dtos.ClienteDTO;
import com.unla.grupo37.dtos.ProductoDTO;
import com.unla.grupo37.repositorios.IUsuarioRolRepositorio;
import com.unla.grupo37.servicios.implementacion.UsuarioRolServicio;

@Controller
@RequestMapping("/admin/informes/usuarios")
public class AdminInformeRankingClientesControlador {

	private UsuarioRolServicio uRServ;
	
	public AdminInformeRankingClientesControlador(UsuarioRolServicio uRServ) {
		this.uRServ=uRServ;
	}
	
	@GetMapping("")
	public ModelAndView informeCliente() {
		String aux = com.unla.grupo37.controladores.PermisosDeVista.getInstancia().permisoVista();
		
		boolean conPermiso = aux.equals("Ok");
		ModelAndView mav = null;
		
		if (conPermiso) {
			mav = new ModelAndView(AyudanteRutasVistas.ADMIN_INFORMES_CLIENTES);
			
			List<ClienteDTO> clientes = uRServ.getAllClientes();
			clientes.sort(Comparator.comparingDouble(ClienteDTO::getGastoTotal).reversed());
			
			mav.addObject("clientes", clientes);
			
		}else {
			mav = new ModelAndView(aux);
		}
		
		return mav;
	}
	
}
