package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class NovoFilmeAtor {
	public static void main(String[] args) {
		Filme filmeA = new Filme("Star Wars Ep 4", 8.9);
		Filme filmeB = new Filme("O Fugitivo", 8.1);
		
		
		Ator atorA = new Ator("Harrison Ford");
		Ator atrizB = new Ator("Carrie Fisher");
		
		filmeA.adicionarAtor(atorA);
		filmeA.adicionarAtor(atrizB);
		
		filmeB.adicionarAtor(atorA);
		
		DAO<Filme> dao = new DAO<>();
		dao.incluirAtomico(filmeA);
		
		/*Quando ele iserir o filmeA ele vai em cascata inserir
		 *  o atorA e a atrizB, Quando ele inserir o atorA ou atrizB
		 * ele vai inserir os filmes que est�o vinculados a esses atores.
		 * Sendo assim, o filmeA, filmeB, atorA e atorB ser�o incluidos 
		 * na base de dados*/
	}
}
