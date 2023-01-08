package muitospramuitos;

import org.junit.jupiter.api.Test;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

class NovoFilmeAtor {

	@Test
	void test() {
		
		Filme filmeA = new Filme("Star Wars", 8.7);
		
		Ator atorA = new Ator("Harrison Ford");
		Ator atrizB = new Ator("Carrie Fisher");
		
		filmeA.addAtor(atorA);
		filmeA.addAtor(atrizB);
		
		DAO<Filme> dao = new DAO<>();
		
		dao.incluirAtomico(filmeA);
		
	}

}
