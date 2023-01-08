import org.junit.jupiter.api.Test;

import infra.DAO;
import modelo.basico.Produto;

class TesteDAO {

	@Test
	void testInserir() {
		DAO<Produto> dao = new DAO<>(Produto.class);
		Produto produto = new Produto("Monitor 23", 789.98);
		
		dao.incluirAtomico(produto).fechar();
		System.out.println("Id do produto: "+produto.getId());
		
	}

	
}
