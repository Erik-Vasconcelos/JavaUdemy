package orientacao_obj.heranca.loja;
	/*Crie uma hierarquia de classes de dom�nio para uma loja que venda livros, CDs e DVDs. Sobrescreva o
	m�todo toString() para que imprima:
	� Para livros: nome, pre�o e autor;
	� Para CDs: nome, pre�o e n�mero de faixas;
	� Para DVDs: nome, pre�o e dura��o.
	Evite ao m�ximo repeti��o de c�digo utilizando a palavra super no construtor e no m�todo sobrescrito. Em
	seguida, crie uma classe Loja com o m�todo main() que adicione 5 produtos diferentes (a sua escolha) a
	um vetor e, por fim, imprima o conte�do do vetor.
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
