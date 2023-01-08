package orientacao_obj.heranca.loja;
	/*Crie uma hierarquia de classes de domínio para uma loja que venda livros, CDs e DVDs. Sobrescreva o
	método toString() para que imprima:
	• Para livros: nome, preço e autor;
	• Para CDs: nome, preço e número de faixas;
	• Para DVDs: nome, preço e duração.
	Evite ao máximo repetição de código utilizando a palavra super no construtor e no método sobrescrito. Em
	seguida, crie uma classe Loja com o método main() que adicione 5 produtos diferentes (a sua escolha) a
	um vetor e, por fim, imprima o conteúdo do vetor.
	*/
public class Produto {

	String nome;
	double preco;
	
	
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
		
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome+" R$"+preco+" ";
	}
}
