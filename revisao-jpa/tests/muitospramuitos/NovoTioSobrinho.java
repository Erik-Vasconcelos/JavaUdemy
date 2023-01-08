package muitospramuitos;

import org.junit.jupiter.api.Test;

import infra.DAO;
import modelo.muitospramuitos.Sobrinho;
import modelo.muitospramuitos.Tio;

class NovoTioSobrinho {

	@Test
	void test() {
		Tio tia1 = new Tio("Maria");
		Tio tio2 = new Tio("João");
		
		Sobrinho sobrinho1 = new Sobrinho("Davi");
		Sobrinho sobrinha2 = new Sobrinho("Ana");
		
		tia1.addSobrinho(sobrinho1);
		tia1.addSobrinho(sobrinha2);
		
		tio2.addSobrinho(sobrinho1);
		tio2.addSobrinho(sobrinha2);
		 
		DAO<Object> dao = new DAO<>();
		
		dao.abrirT()
		.incluir(tia1)
		.incluir(tio2)
		.incluir(sobrinho1)
		.incluir(sobrinha2)
		.fecharT()
		.fechar();
	
	}

}
