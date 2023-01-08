package umpraum;

import org.junit.jupiter.api.Test;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

class TesteNovoCliente {

	/*@Test
	void test() {
		
		Assento assento = new Assento("16A");
		Cliente cliente = new Cliente("Carlos", assento);
		
		DAO<Object> dao = new DAO<>();
		
		dao.abrirT()
			.incluir(cliente)
			.incluir(assento)
			.fecharT()
			.fechar();
	}*/
	
	@Test
	void testNovoAssento2() {
		
		Assento assento = new Assento("4D");
		Cliente cliente = new Cliente("RODRIGO", assento);
		
		DAO<Cliente> dao = new DAO<>();
		
		dao.incluirAtomico(cliente);
		
	
	}

}
