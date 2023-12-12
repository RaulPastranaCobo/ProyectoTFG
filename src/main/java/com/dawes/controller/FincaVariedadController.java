package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.FincaVariedadVO;
import com.dawes.servicio.FincaVariedadServicio;

@Controller
@RequestMapping("/fincavariedades")
public class FincaVariedadController {

	@Autowired
	FincaVariedadServicio fvs;
	
	@RequestMapping("/mostrar")
	public String mostrar (Model modelo) {
		modelo.addAttribute("fincavariedades", fvs.findAll());
		return "fincavariedades/mostrarfincavariedades";
		
	}
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("fincavariedad", new FincaVariedadVO());
		return  "/fincavariedades/insertarfincavariedades";
	}
	
	@RequestMapping("/insertar")
	public String forminsertar(@ModelAttribute FincaVariedadVO fincavariedad, Model modelo) {
		fvs.save(fincavariedad);
		modelo.addAttribute("fincavariedades", fvs.findAll());
		return  "/fincavariedades/mostrarfincavariedades";
	}
	
	@RequestMapping("/formmodificar")
	public String formmodificar(@RequestParam int idfincavariedad, Model modelo) {
		modelo.addAttribute("fincavariedad", fvs.findById(idfincavariedad).get());
		return  "fincavariedades/modificarfincavariedades";
	}
	
	@RequestMapping("/eliminar")
	public String formeliminar(@RequestParam int idfincavariedad, Model modelo) {
		fvs.deleteById(idfincavariedad);
		modelo.addAttribute("fincavariedades", fvs.findAll());
		return  "redirect:/fincavariedades/mostrar";
	}
}
