package com.mihuella.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {
	@GetMapping("/")
	public String paginaDeInicio() {
		return "index";
	}
}