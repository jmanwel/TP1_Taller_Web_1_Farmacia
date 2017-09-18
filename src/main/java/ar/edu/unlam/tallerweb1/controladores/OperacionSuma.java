package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OperacionSuma {
	@RequestMapping("operacion/{suma}/{valor1}/{valor2}")
	public ModelAndView sumar 
	(@PathVariable("suma") String suma, @PathVariable ("valor1") Integer valor1, @PathVariable ("valor2") Integer valor2)
	
	{
		ModelMap modelosuma = new ModelMap();
		modelosuma.put("suma",suma);
		modelosuma.put("valor1",valor1);
		modelosuma.put("valor2",valor2);
		
	if(suma.equalsIgnoreCase("sumar"))	
	{
		Integer resultado = valor1 + valor2;
		modelosuma.put("resultado",resultado);
		
		return new ModelAndView ("resultado-suma",modelosuma);
	}
		
	return new ModelAndView ("resultado-invalido",modelosuma);
		
	}

}
