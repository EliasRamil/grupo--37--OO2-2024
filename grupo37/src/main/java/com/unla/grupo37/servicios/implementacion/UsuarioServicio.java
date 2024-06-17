package com.unla.grupo37.servicios.implementacion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unla.grupo37.entidades.RolDeUsuario;
import com.unla.grupo37.entidades.Usuario;
import com.unla.grupo37.repositorios.IUsuarioRepositorio;

@Service("usuarioServicio")
public class UsuarioServicio implements UserDetailsService {
	private IUsuarioRepositorio uR;

	public UsuarioServicio (IUsuarioRepositorio uR) {
		this.uR = uR;
	}

	@Override
	public UserDetails loadUserByUsername(String nombreDeUsuario) throws UsernameNotFoundException {
		Usuario u = uR.findByNombreDeUsuarioAndFetchRolesDeUsuarioEagerly(nombreDeUsuario);
		if (u == null) throw new UsernameNotFoundException("Este usuario no existe");
		return construirUsuario(u, construirAutoridadesConcedidas(u.getRolesDeUsuario()));
	}
	
	public Usuario traerUsuario(String nombreDeUsuario) {
		return uR.findByNombreDeUsuarioAndFetchRolesDeUsuarioEagerly(nombreDeUsuario);
	}

	private User construirUsuario(Usuario u, List<GrantedAuthority> grantedAuthorities) {
		return new User(u.getNombreDeUsuario(), u.getClave(), u.isActivada(),
						true, true, true, //accountNonExpired, credentialsNonExpired, accountNonLocked,
						grantedAuthorities);
	}

	private List<GrantedAuthority> construirAutoridadesConcedidas(Set<RolDeUsuario> rU) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for(RolDeUsuario rolDeUsuario: rU) {
			grantedAuthorities.add(new SimpleGrantedAuthority(rolDeUsuario.getRol()));
		}
		return new ArrayList<>(grantedAuthorities);
	}
	
}
