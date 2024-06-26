package com.unla.grupo37.ayudante;

public class AyudanteRutasVistas {
	
	//USUARIO
	public final static String USER_LOGIN = "user/login";
	public final static String USER_LOGOUT = "user/logout";
	
	//COMPRA:
	public final static String COMPRA_INDEX = "compra/index";
	
	//ADMIN:
	public final static String ADMIN_INDEX = "admin/index";
	public final static String ADMIN_PEDIDO = "admin/pedido";
	public final static String ADMIN_LOTE = "admin/lote";
	public final static String ADMIN_ABM = "admin/ABMadmin";
	public final static String ADMIN_ALTA = "admin/CrearProducto";
	public final static String ADMIN_MODIFICACION = "admin/ActualizarProducto";
	
	//INFORMES:
	public final static String ADMIN_INFORMES_INDEX = "admin/informes/InicioInformes";
	public final static String ADMIN_INFORMES_INVENTARIO = "admin/informes/productos-inventario";
	public final static String ADMIN_INFORMES_LOTES = "admin/informes/lotes";
	public final static String ADMIN_INFORMES_CLIENTES = "admin/informes/rankingUsuario";
	public final static String ADMIN_INFORMES_RANKING_PRODUCTO = "admin/informes/rankingProducto";
	
	//REDIRECCIONAR:
	public final static String LOGIN_ROOT = "redirect:/login";
	public final static String COMPRA_ROOT = "redirect:/compra";
	public final static String ADMIN_ROOT = "redirect:/admin";
	public final static String ADMIN_LOTE_ROOT = "redirect:/admin/lote";
	public final static String ADMIN_ABM_ROOT = "redirect:/admin/abm";
	
	//ERROR:
	public final static String E_403 = "error/403";
}
