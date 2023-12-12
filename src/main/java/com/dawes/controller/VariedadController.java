package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.VariedadVO;
import com.dawes.servicio.VariedadServicio;

@Controller
@RequestMapping("/variedades")
public class VariedadController {

	@Autowired
	VariedadServicio vs;
	
	@RequestMapping("/mostrar")
	public String mostrar (Model modelo) {
		modelo.addAttribute("variedades", vs.findAll());
		return "variedades/mostrarvariedades";
		
	}
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("variedad", new VariedadVO());
		return  "/variedades/insertarvariedades";
	}
	
	@RequestMapping("/insertar")
	public String forminsertar(@ModelAttribute VariedadVO variedad, Model modelo) {
		vs.save(variedad);
		modelo.addAttribute("variedades", vs.findAll());
		return  "/variedades/mostrarvariedades";
	}
	
	@RequestMapping("/formmodificar")
	public String formmodificar(@RequestParam int idvariedad, Model modelo) {
		modelo.addAttribute("variedad", vs.findById(idvariedad).get());
		return  "variedades/modificarvariedades";
	}
	
	@RequestMapping("/eliminar")
	public String formeliminar(@RequestParam int idvariedad, Model modelo) {
		vs.deleteById(idvariedad);
		modelo.addAttribute("variedades", vs.findAll());
		return  "redirect:/variedades/mostrar";
	}
}