package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.VariedadTratamientoFincaVO;
import com.dawes.servicio.VariedadTratamientoFincaServicio;

@Controller
@RequestMapping("/variedadtratamientofincas")
public class VariedadTratamientoFincaController {

	@Autowired
	VariedadTratamientoFincaServicio vtfs;
	
	@RequestMapping("/mostrar")
	public String mostrar (Model modelo) {
		modelo.addAttribute("variedadtratamientofincas", vtfs.findAll());
		return "variedadtratamientofincas/mostrarvariedadtratamientofincas";
		
	}
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("variedadtratamientofinca", new VariedadTratamientoFincaVO());
		return  "/variedadtratamientofincas/insertarvariedadtratamientofincas";
	}
	
	@RequestMapping("/insertar")
	public String forminsertar(@ModelAttribute VariedadTratamientoFincaVO variedadtratamientofinca, Model modelo) {
		vtfs.save(variedadtratamientofinca);
		modelo.addAttribute("variedadtratamientofincas", vtfs.findAll());
		return  "/variedadtratamientofincas/mostrarvariedadtratamientofincas";
	}
	
	@RequestMapping("/formmodificar")
	public String formmodificar(@RequestParam int idvariedadtratamientofinca, Model modelo) {
		modelo.addAttribute("variedadtratamientofinca", vtfs.findById(idvariedadtratamientofinca).get());
		return  "variedadtratamientofincas/modificarvariedadtratamientofincas";
	}
	
	@RequestMapping("/eliminar")
	public String formeliminar(@RequestParam int idvariedadtratamientofinca, Model modelo) {
		vtfs.deleteById(idvariedadtratamientofinca);
		modelo.addAttribute("variedadtratamientofincas", vtfs.findAll());
		return  "redirect:/variedadtratamientofincas/mostrar";
	}
}
