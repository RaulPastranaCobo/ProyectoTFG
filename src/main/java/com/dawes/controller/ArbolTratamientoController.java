package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.ArbolTratamientoVO;
import com.dawes.servicio.ArbolTratamientoServicio;

@Controller
@RequestMapping("/arboltratamientos")
public class ArbolTratamientoController {

	@Autowired
	ArbolTratamientoServicio ats;
	
	@RequestMapping("/mostrar")
	public String mostrar (Model modelo) {
		modelo.addAttribute("arboltratamientos", ats.findAll());
		return "arboltratamientos/mostrararboltratamientos";
		
	}
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("arboltratamiento", new ArbolTratamientoVO());
		return  "/arboltratamientos/insertararboltratamientos";
	}
	
	@RequestMapping("/insertar")
	public String forminsertar(@ModelAttribute ArbolTratamientoVO arboltratamiento, Model modelo) {
		ats.save(arboltratamiento);
		modelo.addAttribute("arboltratamientos", ats.findAll());
		return  "/arboltratamientos/mostrararboltratamientos";
	}
	
	@RequestMapping("/formmodificar")
	public String formmodificar(@RequestParam int idarboltratamiento, Model modelo) {
		modelo.addAttribute("arboltratamiento", ats.findById(idarboltratamiento).get());
		return  "arboltratamientos/modificararboltratamientos";
	}
	
	@RequestMapping("/eliminar")
	public String formeliminar(@RequestParam int idarboltratamiento, Model modelo) {
		ats.deleteById(idarboltratamiento);
		modelo.addAttribute("arboltratamientos", ats.findAll());
		return  "redirect:/arboltratamientos/mostrar";
	}
}
