package umpramuitos;

import org.junit.jupiter.api.Test;

import infra.DAO;
import modelo.umpramuitos.Pedido;

class ObterPedido {

	@Test
	void test() {
		DAO<Pedido> dao = new DAO<>(Pedido.class);
		Pedido pedido = dao.obterPorId(1L);
		
		pedido.getItens().stream()
			.map(i -> i.getProduto().getNome())
			.forEach(System.out::println);
		
	}

}
