package com.unla.grupo37.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo37.ayudante.AyudanteRutasVistas;

@Controller
@RequestMapping("/")
public class HomeControlador {

	@GetMapping("/index")
	public String index() {
		return AyudanteRutasVistas.INDEX;
	}
	
	//redirecciona a index si se busca una url vacia
	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView (AyudanteRutasVistas.ROUTE_INDEX);	
	}
		
	//GET example: SERVER/hello?name=someName
	@GetMapping("/hola")
	public ModelAndView helloParams1(@RequestParam(name="name", required=false, defaultValue="null") String name) {
		ModelAndView mV = new ModelAndView(AyudanteRutasVistas.HELLO);
		mV.addObject("name",name);
		return mV;
	}
		
	//GET example: SERVER/hello?name=someName
	@GetMapping("/hola/{nombre}")
	public ModelAndView helloParams2(@PathVariable("nombre") String name) {
		ModelAndView mV = new ModelAndView(AyudanteRutasVistas.HELLO);
		mV.addObject("name",name);
		return mV;
	}
	
}
