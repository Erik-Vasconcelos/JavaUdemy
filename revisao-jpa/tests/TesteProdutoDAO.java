import java.util.List;

import org.junit.jupiter.api.Test;

import infra.ProdutoDAO;
import modelo.basico.Produto;

class TesteProdutoDAO {

	@Test
	void testObterProdutos() {
		ProdutoDAO dao = new ProdutoDAO();
		
		List<Produto> produtos = dao.obterTodos();
//		
//		for(Produto produto : produtos) {
//			System.out.println(produto.getNome() +"-->"+ produto.getPreco());
//		}
		
		produtos.stream().forEach(p -> System.out.println(p.getNome() +"-->"+ p.getPreco()));
		
		double precoTotal = produtos.stream()
				.map(p -> p.getPreco())
				.reduce(0.0, (t, p) -> t + p);
		System.out.println(precoTotal);
		
		dao.fechar();
	}
	


}
