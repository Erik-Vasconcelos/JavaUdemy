package classes_e_metodos;

public class TesteProduto {
	public static void main(String[] args) {
		Produto p1 = new Produto();
		p1.nome ="Notebook";
		p1.preco=4567.98;
		System.out.println(p1.nome);
		System.out.println(p1.precoComDesconto());
		System.out.println(p1.precoComDesconto(0.20));
		
		//Usando o Construtor criado
		
		Produto.desconto = 0.35;
		Produto p2 =new Produto("celular", 2167.56);
		System.out.println(p2.precoComDesconto());
	}
}
