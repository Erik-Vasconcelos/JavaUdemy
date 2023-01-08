package com.exercicio.projetosb.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.projetosb.model.Cliente;
import com.exercicio.projetosb.repositories.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping
	public Cliente novoCliente(@Valid Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
	}
	
	@GetMapping
	public Iterable<Cliente> obterClientes() {
		return clienteRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Cliente> obterCliente(@PathVariable Long id) {
		return clienteRepository.findById(id);
	}
	
	
	@GetMapping("/paginacao")
	public Iterable<Cliente> obterClienteComPaginacao(
			@RequestParam(name = "np", defaultValue = "0") int numeroPagina,
			@RequestParam(name = "ne", defaultValue = "5") int qtdElementos){
		
		if(qtdElementos > 5) qtdElementos = 5;
		
		Pageable page = PageRequest.of(numeroPagina, qtdElementos);
		return clienteRepository.findAll(page);
	}
	
	@GetMapping("/nome")
	public Iterable<Cliente> obterPorNome(@RequestParam(name = "nome") String nome){
		return clienteRepository.findByNomeContaining(nome);
		
	}
	
	@GetMapping("/cpf/{cpf}")
	public Optional<Cliente> obterClientePorCpf(@PathVariable String cpf){
		return clienteRepository.findByCpf(cpf);
	}
	
	@GetMapping("/idade/{idade}")
	public Iterable<Cliente> obterClienteComIdadeMaiorQue(@PathVariable int idade){
		return clienteRepository.searchByIdadeBiggerThen(idade);
	}
	
	@PutMapping
	public Cliente atualizarCliente(@Valid Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
	}
	
	@DeleteMapping("/{id}")
	public void excluirCliente(@PathVariable Long id) {
		clienteRepository.deleteById(id);
	}
}
