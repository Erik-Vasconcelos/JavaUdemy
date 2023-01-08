package br.com.cod3r.exerciciossb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.model.entities.Usuario;
import br.com.cod3r.exerciciossb.model.repositories.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/novo")
	public Usuario novoUsuario(@RequestParam String nome, @RequestParam String login) {
		Usuario usuario = new Usuario(nome, login);
		usuarioRepository.save(usuario);
		return usuario;
	}

}
