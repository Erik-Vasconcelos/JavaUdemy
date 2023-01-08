package heranca;

import org.junit.jupiter.api.Test;

import infra.DAO;
import modelo.heranca.Aluno;
import modelo.heranca.AlunoBolsista;

class TesteHeren {

	@Test
	void test() {
		DAO<Aluno> dao = new DAO<>();
		
		Aluno aluno = new Aluno(123L, "João");
		AlunoBolsista alunoBolsista = new AlunoBolsista(345L, "Carlos", 1000.0);
		
		dao.incluirAtomico(aluno);
		dao.incluirAtomico(alunoBolsista);
	
		dao.fechar();
;	}

}
