package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.TratamientoVO;
import com.dawes.servicio.TratamientoServicio;

@Controller
@RequestMapping("/tratamientos")
public class TratamientoController {

	@Autowired
	TratamientoServicio ts;
	
	@RequestMapping("/mostrar")
	public String mostrar (Model modelo) {
		modelo.addAttribute("tratamientos", ts.findAll());
		return "tratamientos/mostrartratamientos";
		
	}
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("tratamiento", new TratamientoVO());
		return  "/tratamientos/insertartratamientos";
	}
	
	@RequestMapping("/insertar")
	public String forminsertar(@ModelAttribute TratamientoVO tratamiento, Model modelo) {
		ts.save(tratamiento);
		modelo.addAttribute("tratamientos", ts.findAll());
		return  "/tratamientos/mostrartratamientos";
	}
	
	@RequestMapping("/formmodificar")
	public String formmodificar(@RequestParam int idtratamiento, Model modelo) {
		modelo.addAttribute("tratamiento", ts.findById(idtratamiento).get());
		return  "tratamientos/modificartratamientos";
	}
	
	@RequestMapping("/eliminar")
	public String formeliminar(@RequestParam int idtratamiento, Model modelo) {
		ts.deleteById(idtratamiento);
		modelo.addAttribute("tratamientos", ts.findAll());
		return  "redirect:/tratamientos/mostrar";
	}
}