package com.exercicio.projetosb.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.exercicio.projetosb.model.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository <Cliente, Long>{
	
	public Iterable<Cliente> findByNomeContaining(String nome);
	
	public Optional<Cliente> findByCpf(String cpf);
	
	@Query("SELECT c FROM Cliente c WHERE c.idade > :idade")
	public Iterable<Cliente> searchByIdadeBiggerThen(int idade);
	
	//BiggerThen - Provavelmete nao é uma convenção
}
