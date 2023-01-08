package lambdas;

public class Produto {
	String nome;
	double preco;
	double deconto;
	
	public Produto(String nome, double preco, double deconto) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.deconto = deconto;
	}
	
	@Override
	public String toString() {
		return nome+" "+preco;
	}
}
