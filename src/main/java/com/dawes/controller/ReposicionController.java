package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.ReposicionVO;
import com.dawes.servicio.ReposicionServicio;

@Controller
@RequestMapping("/reposiciones")
public class ReposicionController {

	@Autowired
	ReposicionServicio reps;
	
	@RequestMapping("/mostrar")
	public String mostrar (Model modelo) {
		modelo.addAttribute("reposiciones", reps.findAll());
		return "reposiciones/mostrarreposiciones";
		
	}
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("reposicion", new ReposicionVO());
		return  "/reposiciones/insertarreposiciones";
	}
	
	@RequestMapping("/insertar")
	public String forminsertar(@ModelAttribute ReposicionVO reposicion, Model modelo) {
		reps.save(reposicion);
		modelo.addAttribute("reposiciones", reps.findAll());
		return  "/reposiciones/mostrarreposiciones";
	}
	
	@RequestMapping("/formmodificar")
	public String formmodificar(@RequestParam int idreposicion, Model modelo) {
		modelo.addAttribute("reposicion", reps.findById(idreposicion).get());
		return  "reposiciones/modificarreposiciones";
	}
	
	@RequestMapping("/eliminar")
	public String formeliminar(@RequestParam int idreposicion, Model modelo) {
		reps.deleteById(idreposicion);
		modelo.addAttribute("reposiciones", reps.findAll());
		return  "redirect:/reposiciones/mostrar";
	}
}