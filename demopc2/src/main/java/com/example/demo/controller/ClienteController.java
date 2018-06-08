package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Cliente;
import com.example.demo.iservice.IClienteService;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
	@Autowired
	private IClienteService servicio;
	
	@RequestMapping(value="/form")
	public String crear(Model model) {
		Cliente cliente=new Cliente();
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "crear");
		return "form";
	}
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listar");
		model.addAttribute("clientes",servicio.findall());
		return "listar";
		
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, Model model, RedirectAttributes flash, BindingResult result) {
				
		servicio.save(cliente);
		
		flash.addFlashAttribute("success","agregado correctamente");
		
		return "redirect:/listar";
	}
	
}
