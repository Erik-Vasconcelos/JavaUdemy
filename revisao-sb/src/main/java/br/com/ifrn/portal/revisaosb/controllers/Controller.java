package br.com.ifrn.portal.revisaosb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping(path = {"/ola"})
	public String ola() {
		return "Olá, essa é uma revisão Spring Boot";
	}
	
	@PutMapping(path = {"/saudacao"})
	public String saudacao() {
		return "Olá, essa é uma revisão Spring Boot";
	}

}
