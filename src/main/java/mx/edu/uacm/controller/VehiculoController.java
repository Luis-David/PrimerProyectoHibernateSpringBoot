package mx.edu.uacm.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.edu.uacm.domain.Vehiculo;

@Controller
public class VehiculoController {
	
	private static final Logger log= LogManager.getLogger(VehiculoController.class);
	public String guaradarVehiculo;
	@RequestMapping(value="/guardar",method=RequestMethod.POST)
	public String guardarVehiculo(Vehiculo vehiculo) {
		log.debug("Entrando al metodo guardar vehiculo");
		log.debug("Modelo: "+vehiculo.getModelo());
		return "redirect:/";
	}
}
