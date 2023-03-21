package br.com.ifrn.portal.revisaosb.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.ifrn.portal.revisaosb.models.entities.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer>{

	public Iterable<Cliente> findByNomeContainingIgnoreCase(String parteNome);
	
	public Iterable<Cliente> findByNomeStartsWith(String parteNome);
	
	public Iterable<Cliente> findByNomeEndsWith(String parteNome);
	
	public Iterable<Cliente> findByNomeNotContaining(String parteNome);
	
	@Query("select c from Cliente c where c.nome like %:nome%")
	public Iterable<Cliente> searchByNomeLike(@Param("nome") String parteNome);
	
}
	