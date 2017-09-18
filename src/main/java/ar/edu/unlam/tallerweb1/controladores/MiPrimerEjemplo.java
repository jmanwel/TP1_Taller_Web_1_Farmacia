package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;

@Controller
public class MiPrimerEjemplo {
	
//	@RequestMapping("/primerej")
//	public ModelAndView irAEj() {
//	ModelMap model1 = new ModelMap();
//	String nombre ="Juan";
//	model1.put("nombreEnLaVista",nombre);
//	return new ModelAndView("primerej",model1);
//	}
	
	
	
	@RequestMapping("/primerej")
	public ModelAndView irAEj(@RequestParam("nombre")String nombreModelo,@RequestParam("apellido")String apellidoModelo) {
	ModelMap model1 = new ModelMap();
	
	model1.put("nombreEnLaVista",nombreModelo);
	model1.put("apellidoEnLaVista",apellidoModelo);
	
	return new ModelAndView("primerej",model1);
	}
	
	@RequestMapping ("/segej")
		public ModelAndView irSegEjj() {	
		
		ModelMap model2 = new ModelMap();
		ArrayList<String> l1 = new ArrayList<String>();
		
		l1.add("Hola");
		l1.add("Mundo");
		l1.add("Hola");
		l1.add("Mundo");
		
		model2.put("listaEnVista",l1);
		return new ModelAndView ("/segej",model2);
		
	}

}
