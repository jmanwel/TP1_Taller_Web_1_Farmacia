package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Persona;

@Controller
public class ClasePost {
	
	@RequestMapping("/formulario")
	public ModelAndView irAForm ()	
	{
		ModelMap model = new ModelMap();
		Persona persona = new Persona();
		model.put("persona", persona);
	
	return new ModelAndView("formulario",model);
	}
	
	
	@RequestMapping(path="/saludo", method = RequestMethod.POST)
	public ModelAndView saludo (@ModelAttribute ("persona") Persona persona , HttpServletRequest request) {
	ModelMap model = new ModelMap();
	model.put("nombre", persona.getNombre());
	model.put("apellido", persona.getApellido());
	model.put("mail", persona.getMail());
	
	return new ModelAndView("form_rta",model);
	
	

}
}
