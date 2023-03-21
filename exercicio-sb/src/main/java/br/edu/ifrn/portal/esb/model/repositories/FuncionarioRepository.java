package br.edu.ifrn.portal.esb.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.edu.ifrn.portal.esb.model.entities.Funcionario;

public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Long>{
	
	public Iterable<Funcionario> findByNomeContaining(String nome);
	
	public Iterable<Funcionario> findByNomeNotContaining(String nome);
	
	@Query("SELECT f FROM Funcionario f WHERE f.endereco.logradouro LIKE %:logradouro%")
	public Iterable<Funcionario> findByLogradouroEndereco(String logradouro);

}
