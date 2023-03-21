package br.com.ifrn.portal.revisaosb.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifrn.portal.revisaosb.models.entities.Cliente;
import br.com.ifrn.portal.revisaosb.models.repositories.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/{id}")
	public Optional<Cliente> obterClientePorId(@PathVariable int id) {
		return clienteRepository.findById(id);
	}
	
	@GetMapping
	public Iterable<Cliente> obterTodos() {
		return clienteRepository.findAll();
	}
	
	@GetMapping(path = "/pagina/{numeroPagina}/{qtdPagina}")
	public Iterable<Cliente> obterTodosPorPaginacao(@PathVariable int numeroPagina, @PathVariable int qtdPagina) {
		if(qtdPagina > 5 ) qtdPagina = 5;
		
		Pageable page  = PageRequest.of(numeroPagina, qtdPagina);
		return clienteRepository.findAll(page);
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Cliente inseir(@Valid Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
	}
	
	@DeleteMapping(path = "/{id}")
	public void excluir(@PathVariable int id) {
		clienteRepository.deleteById(id);
	}
	
	@GetMapping("/nome/{parteNome}")
	public Iterable<Cliente> obterClientePorNome(@PathVariable String parteNome){
		return clienteRepository.findByNomeStartsWith(parteNome);
		
		//return clienteRepository.findByNomeContainingIgnoreCase(parteNome);
	}
	
	@GetMapping("/nome/comeca/{parteNome}")
	public Iterable<Cliente> obterClienteComecandoCom(@PathVariable String parteNome){
		return clienteRepository.findByNomeStartsWith(parteNome);
	}
	
	@GetMapping("/nome/termina/{parteNome}")
	public Iterable<Cliente> obterClienteTerminandoCom(@PathVariable String parteNome){
		return clienteRepository.findByNomeEndsWith(parteNome);
	}
	
	@GetMapping("/nome/ncontains/{parteNome}")
	public Iterable<Cliente> obterClienteNaoContendoCom(@PathVariable String parteNome){
		
		return clienteRepository.findByNomeNotContaining(parteNome);
	}
	
	/*@GetMapping
	public Cliente obterClientePorId1(
			@RequestParam(name = "id", required = true) int id,
			@RequestParam(name = "nome", defaultValue = "Erik", required = true) String nome,
			@RequestParam(name = "email", defaultValue = "alguem@gmail.com") String email) {
		return new Cliente(id,  nome, email);
	}*/
	
}
