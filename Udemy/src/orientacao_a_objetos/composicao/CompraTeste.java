package orientacao_a_objetos.composicao;

public class CompraTeste {
	
	public static void main(String[] args) {
		Compra c1 = new Compra();
		c1.cliente= "Erik";
		
		c1.itens.add(new Item("Caneta", 6, 1.90));
		c1.itens.add(new Item("borracha", 3, 4.50));
		c1.itens.add(new Item("Caderno", 5, 22.4));
		c1.itens.size();
		
		System.out.println(c1.valorTortal());
		
	}
}
