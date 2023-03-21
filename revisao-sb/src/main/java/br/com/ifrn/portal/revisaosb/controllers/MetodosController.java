package br.com.ifrn.portal.revisaosb.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/metodos")
public class MetodosController {

	@PostMapping
	public String ola() {
		return "Metodo post";
	}
	
}

