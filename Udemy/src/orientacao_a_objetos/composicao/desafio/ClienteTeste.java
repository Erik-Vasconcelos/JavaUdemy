package orientacao_a_objetos.composicao.desafio;

public class ClienteTeste {
	public static void main(String[] args) {
		Cliente c1 = new Cliente();
		c1.nome = "Erik";
		
		Compra comp1 = new Compra();
		comp1.adicionarItem("Notebook", 4523.98, 2);
		comp1.adicionarItem("Celular", 1691.91, 1);
		
		Compra comp2 = new Compra();
		comp2.adicionarItem("Geladeira", 8753.12, 1);
		comp2.adicionarItem("Tv", 2386.8, 3);
		
		
		
		System.out.println(comp1.obterValorTotal());
		System.out.println(comp2.obterValorTotal());
		
		c1.adicionarCompra(comp1);
		c1.adicionarCompra(comp2);
		System.out.println(c1.obterValorTotal());
		
	}
	

}
