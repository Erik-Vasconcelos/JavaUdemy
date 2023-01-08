package orientacao_a_objetos.composicao;

import java.util.ArrayList;

public class Compra {
	String cliente;
	ArrayList<Item> itens = new ArrayList<Item>();
	
	double valorTortal() {
		double total=0;
		for(Item item: itens) {
			total+= item.preco *item.quantidade;
		}
		return total;
	}
}
