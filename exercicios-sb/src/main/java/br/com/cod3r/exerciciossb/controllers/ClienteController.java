package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.model.entities.Cliente;

@RestController
@RequestMapping(path = "clientes")
//diz que toda a classe está mapeada para essa url
public class ClienteController {
	
	@GetMapping("/qualquer")//nao preciso ter o path se tiver so a url
	public Cliente obterCliente() {
		return new Cliente(28, "Pedro", "123.456.789-00");
	}
	
	@GetMapping("/{id}")
	public Cliente obterClientePorId1(@PathVariable int id) {
		/*o @PathVariable pega o valor dentro da url e passa como parametro.
		 * diz que o parametro esta dentro do path*/
		return new Cliente(id, "Maria", "789.879.979-78");
	}
	
	@GetMapping("/{id}/{nome}")
	public Cliente obterClientePorId1(@PathVariable int id, @PathVariable String nome) {
		/*o @PathVariable pega o valor dentro da url e passa como parametro.
		 * diz que o parametro esta dentro do path*/
		return new Cliente(id, nome, "789.879.979-78");
	}
	
	
	@GetMapping
	public Cliente obterCLientePorId2(
			@RequestParam(name = "id", defaultValue = "1") int id) {
		//o @RequestParam diz que esse paremtro recebe o valor od parametro passado na url
		return new Cliente(id, "Joao Augusto", "111.222.333-44");
	}
	
	@GetMapping("/cadastro")
	public Cliente obterCLientePorId2(
			@RequestParam(name = "id", defaultValue = "1") int id,
			@RequestParam(name = "nome", defaultValue = "Joao") String nome,
			@RequestParam(name = "cpf", defaultValue = "000.000.000-00") String cpf) {
		return new Cliente(id, nome, cpf);
	}
}
