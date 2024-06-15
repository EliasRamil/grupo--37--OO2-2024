package com.unla.grupo37.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unla.grupo37.ayudante.AyudanteRutasVistas;
import com.unla.grupo37.entidades.RolDeUsuario;
import com.unla.grupo37.entidades.Usuario;
import com.unla.grupo37.repositorios.IUsuarioRepositorio;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UsuarioControlador {

	@Autowired
	private IUsuarioRepositorio repo;
	
	
	@GetMapping("/login")
	public String login(Model model,
						@RequestParam(name="error",required=false) String error,
						@RequestParam(name="logout", required=false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return AyudanteRutasVistas.USER_LOGIN;
	}

	@GetMapping("/logout")
	public String logout(Model model) {
		return AyudanteRutasVistas.USER_LOGOUT;
	}

	@GetMapping("/loginsuccess")
	public String loginCheck() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    Object principal = authentication.getPrincipal();
	    String r = AyudanteRutasVistas.LOGIN_ROOT;

	    if (principal instanceof UserDetails) {
	        UserDetails userDetails = (UserDetails) principal;
	        if (userDetails.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
	            // Acciones específicas para el rol "ROLE_ADMIN"
	        } else if (userDetails.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROL_USUARIO"))) {
	            // Acciones específicas para el rol "ROLE_USER"
	        	r = AyudanteRutasVistas.COMPRA_ROOT;
	        }
	    }
		
		return r;
	}
	
	@GetMapping("")
	public String redirect(HttpServletRequest request) {
		Usuario user=repo.findByNombreDeUsuarioAndFetchRolesDeUsuarioEagerly(request.getUserPrincipal().getName());
		String s = AyudanteRutasVistas.LOGIN_ROOT;
		
		for(RolDeUsuario r: user.getRolesDeUsuario()) {
			if(r.getRol().equals("ROL_USUARIO")) {
				s = AyudanteRutasVistas.COMPRA_ROOT;
			}else if(r.getRol().equals("ROL_ADMIN")){
				s = "redirect:/admin";
			}
		}
		
		return s;
	}
	
}
