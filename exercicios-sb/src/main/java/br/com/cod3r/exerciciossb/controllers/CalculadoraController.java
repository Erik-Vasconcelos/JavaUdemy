package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.model.entities.Calculadora;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	// /calculadora/somar/10/20
	@GetMapping("/somar/{a}/{b}")
	public String somar(@PathVariable int a, @PathVariable int b) {
		return Calculadora.somar(a, b);
	}
	
	// /calculadora/subtrair?a=100&b=39
	@GetMapping("/subtrair")
	public String subtrair(
			@RequestParam(name = "a", defaultValue = "50") int a,
			@RequestParam(name = "b", defaultValue = "10") int b) {
		return Calculadora.subtrair(a, b);
	}
	
}
