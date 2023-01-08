package muitospramuitos;

import java.util.List;

import org.junit.jupiter.api.Test;

import infra.DAO;
import modelo.consulta.NotaFilme;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

class ObterFilmes {

	@Test
	void test() {
		DAO<Filme> dao = new DAO<>(Filme.class);
		List<Filme> filmes = 
				dao.consultar("filmesNotaMaiorQue", "nota", 8.5);
		
		for(Filme filme : filmes) {
			System.out.println(filme.getNome() + " ==> " + filme.getNota());
			
			for(Ator ator : filme.getAtores()) {
				System.out.println(ator.getNome());
			}
		}
	}
	
		
		@Test
		void obertMediaFilmes() {
			DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
			NotaFilme nota = dao.consultarUm("mediaGeralFilmes");
			
			System.out.println(nota.getMedia());
			dao.fechar();
			
		}
		
	

}
