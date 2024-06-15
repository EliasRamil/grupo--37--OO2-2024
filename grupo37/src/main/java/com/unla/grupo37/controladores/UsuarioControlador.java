package com.unla.grupo37.controladores;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unla.grupo37.ayudante.AyudanteRutasVistas;

@Controller
public class UsuarioControlador {

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
	    String r = "redirect:/";

	    if (principal instanceof UserDetails) {
	        UserDetails userDetails = (UserDetails) principal;
	        if (userDetails.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
	            // Acciones específicas para el rol "ROLE_ADMIN"
	        } else if (userDetails.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROL_USUARIO"))) {
	            // Acciones específicas para el rol "ROLE_USER"
	        	r += "compra";
	        }
	    }
		
		
		return r;
	}
	
}
