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

import com.example.demo.entity.Cuenta;
import com.example.demo.entity.Movimiento;
import com.example.demo.iservice.ICuentaService;
import com.example.demo.iservice.IMovimientoService;

@Controller
@SessionAttributes("movimiento")
public class MovimientoController {
	@Autowired
	private IMovimientoService servicio;
	
	@Autowired
	private ICuentaService servicio2;
	
	@GetMapping(value="/form3/{id}")
	public String crear(Model model,@PathVariable(value="id") Long id) {
		Movimiento mov=new Movimiento();
		Cuenta cuenta=servicio2.findone(id);
		mov.setCuenta(cuenta);
		model.addAttribute("movimiento", mov);
		model.addAttribute("titulo", "crear");
		return "form3";
	}
	
	@RequestMapping(value="/listar4", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listar");
		model.addAttribute("movimientos",servicio.findall());
		return "listar4";
		
	}
	
	@RequestMapping(value="/form3", method=RequestMethod.POST)
	public String guardar(@Valid Movimiento mov, Model model, RedirectAttributes flash, BindingResult result) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo","crear");
			return "form3";
		}
				
		if(servicio2.validarcontra(mov.getCuenta())) {
			
		servicio.save(mov);
		servicio2.actualizarintentos(mov.getCuenta());
		flash.addFlashAttribute("success","note que si el retiro era mayor a su saldo, no se podra realizar el movimiento.");
		return "redirect:/listar4";
		
		}
		else {
			
			if(servicio2.validarmax(mov.getCuenta())) {
				
					flash.addFlashAttribute("error","mal contrasena");
					model.addAttribute("titulo","intentar de nuevo");
					return "form3";
					
			}else {
				
				flash.addFlashAttribute("error","sobrepaso el limite de intentos, cuenta bloqueada");
				model.addAttribute("titulo","listar");
				return "redirect:/listar2";
			}
		}	

	}
	
	@RequestMapping(value="/listar4/{id}", method=RequestMethod.GET)
	public String listarxcliente(Model model, @PathVariable(value="id")Long id) {
		model.addAttribute("titulo","listar");
		model.addAttribute("movimientos",servicio.findbycuenta(id));
		return "listar5";
	}
	
}
