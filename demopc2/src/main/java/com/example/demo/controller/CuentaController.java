package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Cuenta;
import com.example.demo.iservice.IClienteService;
import com.example.demo.iservice.ICuentaService;

@Controller
@SessionAttributes("cuenta")
public class CuentaController {
	@Autowired
	private ICuentaService servicio;
	
	@Autowired
	private IClienteService servicio2;

	
	@GetMapping(value="/form2/{id}")
	public String crear(Model model,@PathVariable(value="id") Long id) {
		Cuenta cuenta=new Cuenta();
		Cliente cliente=servicio2.findbyid(id);
		cuenta.setCliente(cliente);
		model.addAttribute("cuenta", cuenta);
		model.addAttribute("titulo", "crear");
		return "form2";
	}
	
	@RequestMapping(value="/listar2", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listar");
		model.addAttribute("cuentas",servicio.finall());
		return "listar2";
		
	}
	
	@RequestMapping(value="/listar3/{id}", method=RequestMethod.GET)
	public String listar2(Model model,@PathVariable(value="id") Long id) {
		model.addAttribute("titulo","listar");
		model.addAttribute("cuentas",servicio.findbycliente(id));
		return "listar3";
	}
	
	@RequestMapping(value="/form2", method=RequestMethod.POST)
	public String guardar(@Valid Cuenta cuenta, Model model, RedirectAttributes flash, BindingResult result) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo","crear");
			return "form2";
		}
		
		servicio.save(cuenta);
		
		flash.addFlashAttribute("success","agregado correctamente");
		
		return "redirect:/listar2";
	}
	
}











