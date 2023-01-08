package br.com.cod3r.exerciciossb.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
	
	/*Quando fizer uma requisicao do tipo get, chame o método*/
	/*@RequestMapping(method = RequestMethod.GET)
	public String ola() {
		return "Olá Spring Boot";
	}*/
	
	/*Quando fizer uma requisicao do tipo get e o caminho for /ola, chame o método*/
	/*@RequestMapping(method = RequestMethod.GET, path = "/ola")
	public String ola() {
		return "Olá Spring Boot";
	}*/
	
	/*Realizando um mapeamento mais específico*/
	
	/*para o metodo get quando tiver o caminho /ola*/
	/*@GetMapping(path = "/ola")
	public String ola() {
		return "Olá Spring Boot";
	}*/
	
	/*para o metodo get quando tiver o caminho /ola e /saudacao*/
	@GetMapping(path = {"/ola", "/saudacao"})
	public String ola() {
		return "Olá Spring Boot";
	}
	
	@GetMapping(path = "/hora")
	public String getData() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String hora = sdf.format(new Date().getTime());
		return "A hora atual é: " + hora;
	}
	
	
	
}
