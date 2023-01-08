package strem_api;

public class ProdutoDesafio2 {
	final String nome;
	final double preco;
	double desconto;
	boolean freteGratis;
	
	public ProdutoDesafio2(String nome, double preco, double desconto, boolean freteGratis) {
		
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
		this.freteGratis = freteGratis;
	}
	
	public Double precoFinal() {
		return preco * (1- desconto);
		
	}
	
	
	
	
	
	
}
