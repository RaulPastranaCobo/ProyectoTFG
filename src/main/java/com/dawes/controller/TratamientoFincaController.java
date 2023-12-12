package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.TratamientoFincaVO;
import com.dawes.servicio.TratamientoFincaServicio;

@Controller
@RequestMapping("/tratamientofincas")
public class TratamientoFincaController {

	@Autowired
	TratamientoFincaServicio tfs;
	
	@RequestMapping("/mostrar")
	public String mostrar (Model modelo) {
		modelo.addAttribute("tratamientofincas", tfs.findAll());
		return "tratamientofincas/mostrartratamientofincas";
		
	}
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("tratamientofinca", new TratamientoFincaVO());
		return  "/tratamientofincas/insertartratamientofincas";
	}
	
	@RequestMapping("/insertar")
	public String forminsertar(@ModelAttribute TratamientoFincaVO tratamientofinca, Model modelo) {
		tfs.save(tratamientofinca);
		modelo.addAttribute("tratamientofincas", tfs.findAll());
		return  "/tratamientofincas/mostrartratamientofincas";
	}
	
	@RequestMapping("/formmodificar")
	public String formmodificar(@RequestParam int idtratamientofinca, Model modelo) {
		modelo.addAttribute("tratamientofinca", tfs.findById(idtratamientofinca).get());
		return  "tratamientofincas/modificartratamientofincas";
	}
	
	@RequestMapping("/eliminar")
	public String formeliminar(@RequestParam int idtratamientofinca, Model modelo) {
		tfs.deleteById(idtratamientofinca);
		modelo.addAttribute("tratamientofincas", tfs.findAll());
		return  "redirect:/tratamientofincas/mostrar";
	}
}
