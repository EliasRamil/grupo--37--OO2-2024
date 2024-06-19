package com.unla.grupo37.servicios.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.unla.grupo37.dtos.ClienteDTO;
import com.unla.grupo37.entidades.Compra;
import com.unla.grupo37.entidades.Usuario;
import com.unla.grupo37.repositorios.ICompraRepositorio;
import com.unla.grupo37.repositorios.IUsuarioRolRepositorio;

@Service
public class UsuarioRolServicio{
	
	private IUsuarioRolRepositorio repositorioCliente;
	private ICompraRepositorio repositorioCompra;
	private ModelMapper mM = new ModelMapper();
	
	public UsuarioRolServicio(IUsuarioRolRepositorio repositorioCliente, ICompraRepositorio repositorioCompra){
	  this.repositorioCliente = repositorioCliente;
	  this.repositorioCompra= repositorioCompra;
	}
	
	public Usuario getClienteById(int id) {
		return repositorioCliente.findById(id);
	}
	
	public List<ClienteDTO> getAllClientes(){
		List<Usuario> clientes= repositorioCliente.findAllClientes();
		List<ClienteDTO> clientesDto= new ArrayList<>();
		List<Compra> compras= new ArrayList<>();
		
		for(Usuario c: clientes) {
			double total=0;
			compras=repositorioCompra.findAllComprasByIdCliente(c.getId());
			
			for(Compra compra: compras) {
				total=total + compra.getTotal();
				
			}
			
			ClienteDTO clientedto= mM.map(c, ClienteDTO.class);
			clientedto.setGastoTotal(total);
			clientesDto.add(clientedto);
			
		}
		
		return clientesDto;
		
	}
}
