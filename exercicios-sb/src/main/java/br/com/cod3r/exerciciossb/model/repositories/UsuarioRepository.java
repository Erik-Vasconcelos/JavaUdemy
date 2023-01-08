package br.com.cod3r.exerciciossb.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.cod3r.exerciciossb.model.entities.Usuario;

public interface UsuarioRepository 
	extends CrudRepository<Usuario, Long>{
	
}
