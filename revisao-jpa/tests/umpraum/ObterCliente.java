package umpraum;

import org.junit.jupiter.api.Test;

import infra.DAO;
import modelo.umpraum.Cliente;

class ObterCliente {

	@Test
	void test() {

		DAO<Cliente> dao = new DAO<>(Cliente.class); 
		
		Cliente cliente = dao.obterPorId(3L);
		
		System.out.println(cliente.getAssento().getNome());
		System.out.println(cliente.getAssento().getCliente().getNome());
		
		dao.fechar();
		
		
	}

}
