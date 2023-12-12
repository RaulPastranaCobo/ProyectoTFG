package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.RecoleccionVO;
import com.dawes.servicio.RecoleccionServicio;

@Controller
@RequestMapping("/recolecciones")
public class RecoleccionController {

	@Autowired
	RecoleccionServicio rs;
	
	@RequestMapping("/mostrar")
	public String mostrar (Model modelo) {
		modelo.addAttribute("recolecciones", rs.findAll());
		return "recolecciones/mostrarrecolecciones";
		
	}
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("recoleccion", new RecoleccionVO());
		return  "/recolecciones/insertarrecolecciones";
	}
	
	@RequestMapping("/insertar")
	public String forminsertar(@ModelAttribute RecoleccionVO recoleccion, Model modelo) {
		rs.save(recoleccion);
		modelo.addAttribute("recolecciones", rs.findAll());
		return  "/recolecciones/mostrarrecolecciones";
	}
	
	@RequestMapping("/formmodificar")
	public String formmodificar(@RequestParam int idrecoleccion, Model modelo) {
		modelo.addAttribute("recoleccion", rs.findById(idrecoleccion).get());
		return  "recolecciones/modificarrecolecciones";
	}
	
	@RequestMapping("/eliminar")
	public String formeliminar(@RequestParam int idrecoleccion, Model modelo) {
		rs.deleteById(idrecoleccion);
		modelo.addAttribute("recolecciones", rs.findAll());
		return  "redirect:/recolecciones/mostrar";
	}
}
