package br.edu.ifrn.portal.esb.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrn.portal.esb.model.entities.Funcionario;
import br.edu.ifrn.portal.esb.model.repositories.FuncionarioRepository;

@RestController
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@GetMapping("/{id}")
	public Optional<Funcionario> obterFuncionario(@PathVariable Long id){
		return funcionarioRepository.findById(id);
	}
	
	@GetMapping
	public Iterable<Funcionario> obterFuncionarios() {
		return funcionarioRepository.findAll();
	}
	
	@GetMapping("/parteNome")
	public Iterable<Funcionario> obterFuncionariosParteNome(@RequestParam(name = "nome", required = true) String nome){
		return funcionarioRepository.findByNomeContaining(nome);
	}
	
	@GetMapping("/parteNome/not")
	public Iterable<Funcionario> obterFuncionariosNaoParteNome(@RequestParam(name = "nome", required = true) String nome){
		return funcionarioRepository.findByNomeNotContaining(nome);
	}
	
	@GetMapping("/logradouro")
	public Iterable<Funcionario> obterFuncionariosPorLogradouro(@RequestParam(name = "logradouro", required = true) String logradouro){
		return funcionarioRepository.findByLogradouroEndereco(logradouro);
	}
	
	@GetMapping("/paginacao/{numeroPage}")
	public Iterable<Funcionario> obterFuncionarios(@PathVariable int numeroPage) {
		Pageable page = PageRequest.of(numeroPage, 3);
		return funcionarioRepository.findAll(page);
	}
	
	@PostMapping
	public Funcionario inserir(@Valid Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
		return funcionario;
	}
	
	@PutMapping("/{id}")
	public Funcionario atualiza(@PathVariable Long id, @Valid Funcionario funcionario) {
		funcionario.setId(id);
		funcionarioRepository.save(funcionario);
		return funcionario;
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		funcionarioRepository.deleteById(id);
	}
	
}
