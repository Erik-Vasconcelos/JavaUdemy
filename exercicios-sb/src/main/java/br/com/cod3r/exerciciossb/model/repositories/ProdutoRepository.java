package br.com.cod3r.exerciciossb.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.cod3r.exerciciossb.model.entities.Produto;

public interface ProdutoRepository 
	extends PagingAndSortingRepository<Produto, Integer> {

	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
	
	/*De acordo com a convencao da nomeclatura do metodo, 
	 * o Spring será o responsavel por implementar o metodo
	 *  criado acima porque ele esta seguindo a convencao de nomes*/
	
	/*-------------------CONVENCOES------------------*/
	//findByNameContaining
	//findByNameIsContaining
	//findByNameContains
	
	//findByNameStartsWith -> Comeca com
	//findByNameEndsWith -> Termina com
	
	//findByNameNotContaining -> Não contendo 

	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome") String nome);
	
	
}
