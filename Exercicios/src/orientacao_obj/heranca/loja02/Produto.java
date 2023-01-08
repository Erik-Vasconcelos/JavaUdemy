package orientacao_obj.heranca.loja02;
	/* Modifique o c�digo do programa anterior, da seguinte forma:
	a) Adicione um atributo que represente o c�digo de barras do produto (� um valor obrigat�rio e,
	portanto, deve ser pedido no construtor);
	b) Sobrescreva o m�todo equals() retornando true se dois produtos possuem o mesmo c�digo de
	barras;
	c) Na classe Loja, implemente um simples procedimento de busca que, dado um produto e um vetor
	de produtos, indique em que posi��o do vetor se encontra o produto especificado ou imprima que o
	mesmo n�o foi encontrado;
	d) No m�todo Loja.main(), ap�s a impress�o do vetor (feita na quest�o 2a), escolha um dos 5
	produtos e crie duas novas inst�ncias id�nticas a ele: uma com o mesmo c�digo de barras e outra
	com o c�digo diferente. Efetue a busca deste produto no vetor utilizando as duas inst�ncias e
	verifique o resultado.
	*/

import java.util.Objects;

public class Produto {
	final Long codigoBarras;
	String nome;
	double preco;
	
	
	public Produto(String nome, double preco, Long codigo) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.codigoBarras= codigo;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome+" R$"+preco+" ";
	}
	
	@Override
	public boolean equals(Object obj) {
		Produto outro = (Produto) obj;
		return Objects.equals(codigoBarras, outro.codigoBarras);	
	}

	
		
}
