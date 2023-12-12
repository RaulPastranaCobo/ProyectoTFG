package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.FincaVO;
import com.dawes.servicio.FincaServicio;

@Controller
@RequestMapping("/fincas")
public class FincaController {

	@Autowired
	FincaServicio fs;
	
	@RequestMapping("/mostrar")
	public String mostrar (Model modelo) {
		modelo.addAttribute("fincas", fs.findAll());
		return "fincas/mostrarFinca";
		
	}
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("finca", new FincaVO());
		return  "/fincas/insertarFinca";
	}
	
	@RequestMapping("/insertar")
	public String forminsertar(@ModelAttribute FincaVO finca, Model modelo) {
		fs.save(finca);
		modelo.addAttribute("fincas", fs.findAll());
		return  "/fincas/mostrarFinca";
	}
	
	@RequestMapping("/formmodificar")
	public String formmodificar(@RequestParam int idfinca, Model modelo) {
		modelo.addAttribute("finca", fs.findById(idfinca).get());
		return  "fincas/modificarFinca";
	}
	
	@RequestMapping("/eliminar")
	public String formeliminar(@RequestParam int idfinca, Model modelo) {
		fs.deleteById(idfinca);
		modelo.addAttribute("fincas", fs.findAll());
		return  "redirect:/fincas/mostrar";
	}
}
