package classes_e_metodos;

public class Produto {
	String nome;
	double preco;
	static double desconto = 0.25;
	
	// Construtore
	public Produto(){
		
	}
	
	Produto(String nomeIni, double precoIni){
		nome = nomeIni;
		preco = precoIni;
		
	}
	
	// Métodos
	static void mudarDesconto(double descontoIni) {
		desconto = descontoIni;
	}
	
	double precoComDesconto() {
		return preco* (1-desconto);
	}
	
	double precoComDesconto(double descontoExtra) {
		return preco* (1- (desconto + descontoExtra));
	}
	
}
