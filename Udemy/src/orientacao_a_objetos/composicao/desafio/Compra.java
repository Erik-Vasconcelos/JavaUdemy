package orientacao_a_objetos.composicao.desafio;

import java.util.ArrayList;

public class Compra {
	ArrayList<Item> itens = new ArrayList<>();
	
	double obterValorTotal() {
		double total=0;
		for(Item iten: itens) {
			total+=iten.quantidade*iten.produto.preco;
		}
		
		return total;
	}
	
	void adicionarItem(Produto p, int quant) {
		this.itens.add(new Item(p, quant));
	}
	void adicionarItem(String nome, double preco, int quant) {
		this.itens.add(new Item(new Produto(nome, preco), quant));
	}
}
