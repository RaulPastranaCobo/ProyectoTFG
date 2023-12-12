package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.ArbolVO;
import com.dawes.servicio.ArbolServicio;

@Controller
@RequestMapping("/arboles")
public class ArbolController {

	@Autowired
	ArbolServicio as;
	
	@RequestMapping("/mostrar")
	public String mostrar (Model modelo) {
		modelo.addAttribute("arboles", as.findAll());
		return "arboles/mostrarArbol";
		
	}
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("arbol", new ArbolVO());
		return  "/arboles/insertarArbol";
	}
	
	@RequestMapping("/insertar")
	public String forminsertar(@ModelAttribute ArbolVO arbol, Model modelo) {
		as.save(arbol);
		modelo.addAttribute("arboles", as.findAll());
		return  "/arboles/mostrarArbol";
	}
	
	@RequestMapping("/formmodificar")
	public String formmodificar(@RequestParam int idarbol, Model modelo) {
		modelo.addAttribute("arbol", as.findById(idarbol).get());
		return  "arboles/modificarArbol";
	}
	
	@RequestMapping("/eliminar")
	public String formeliminar(@RequestParam int idarbol, Model modelo) {
		as.deleteById(idarbol);
		modelo.addAttribute("arboles", as.findAll());
		return  "redirect:/arboles/mostrar";
	}
}
