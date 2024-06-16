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
import com.unla.grupo37.servicios.implementacion.UsuarioServicio;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio uS;
	
	
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
	        if (userDetails.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROL_ADMIN"))) {
	        	r = AyudanteRutasVistas.ADMIN_ROOT;
	        } else if (userDetails.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROL_USUARIO"))) {
	        	r = AyudanteRutasVistas.COMPRA_ROOT;
	        }
	    }
		
		return r;
	}
	
	@GetMapping("")
	public String redirect(HttpServletRequest request) {
		UserDetails userDetails = uS.loadUserByUsername(request.getUserPrincipal().getName());
		String r = AyudanteRutasVistas.LOGIN_ROOT;
		
		/*for(RolDeUsuario r: user.getRolesDeUsuario()) {
			if(r.getRol().equals("ROL_USUARIO")) {
				s = AyudanteRutasVistas.COMPRA_ROOT;
			}else if(r.getRol().equals("ROL_ADMIN")){
				s = AyudanteRutasVistas.ADMIN_ROOT;
			}
		}*/
		
		if (userDetails.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROL_ADMIN"))) {
            // Acciones específicas para el rol "ROLE_ADMIN"
        	r = AyudanteRutasVistas.ADMIN_ROOT;
        } else if (userDetails.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROL_USUARIO"))) {
            // Acciones específicas para el rol "ROLE_USER"
        	r = AyudanteRutasVistas.COMPRA_ROOT;
        }
		
		return r;
	}
	
}
