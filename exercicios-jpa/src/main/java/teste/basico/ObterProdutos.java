package teste.basico;

import java.util.List;

import modelo.basico.Produto;

public class ObterProdutos {
	public static void main(String[] args) {
		
		DAOProduto dao = new DAOProduto();
		
		List<Produto> produtos = dao.obterTodos();
		
		for(Produto produto: produtos) {
			System.out.println("id: "+produto.getId()+"Nome: "+produto.getNome());
		}
		
		Double precoTotal = produtos.stream()
				.map(p -> p.getPreco())
				.reduce(0.0, (t, p) -> t+p)
				.doubleValue();
		System.out.println(precoTotal);
		
		dao.fechar();
	}
}
