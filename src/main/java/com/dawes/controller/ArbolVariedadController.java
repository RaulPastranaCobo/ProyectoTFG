package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.ArbolVariedadVO;
import com.dawes.servicio.ArbolVariedadServicio;

@Controller
@RequestMapping("/arbolvariedades")
public class ArbolVariedadController {

	@Autowired
	ArbolVariedadServicio avs;
	
	@RequestMapping("/mostrar")
	public String mostrar (Model modelo) {
		modelo.addAttribute("arbolvariedades", avs.findAll());
		return "arbolvariedades/mostrararbolvariedades";
		
	}
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("arbolvariedad", new ArbolVariedadVO());
		return  "/arbolvariedades/insertararbolvariedades";
	}
	
	@RequestMapping("/insertar")
	public String forminsertar(@ModelAttribute ArbolVariedadVO arbolvariedad, Model modelo) {
		avs.save(arbolvariedad);
		modelo.addAttribute("arbolvariedades", avs.findAll());
		return  "/arbolvariedades/mostrararbolvariedades";
	}
	
	@RequestMapping("/formmodificar")
	public String formmodificar(@RequestParam int idarbolvariedad, Model modelo) {
		modelo.addAttribute("arbolvariedad", avs.findById(idarbolvariedad).get());
		return  "arbolvariedades/modificararbolvariedades";
	}
	
	@RequestMapping("/eliminar")
	public String formeliminar(@RequestParam int idarbolvariedad, Model modelo) {
		avs.deleteById(idarbolvariedad);
		modelo.addAttribute("arbolvariedades", avs.findAll());
		return  "redirect:/arbolvariedades/mostrar";
	}
}
