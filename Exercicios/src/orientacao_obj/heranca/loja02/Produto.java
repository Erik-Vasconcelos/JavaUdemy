package orientacao_obj.heranca.loja02;
	/* Modifique o código do programa anterior, da seguinte forma:
	a) Adicione um atributo que represente o código de barras do produto (é um valor obrigatório e,
	portanto, deve ser pedido no construtor);
	b) Sobrescreva o método equals() retornando true se dois produtos possuem o mesmo código de
	barras;
	c) Na classe Loja, implemente um simples procedimento de busca que, dado um produto e um vetor
	de produtos, indique em que posição do vetor se encontra o produto especificado ou imprima que o
	mesmo não foi encontrado;
	d) No método Loja.main(), após a impressão do vetor (feita na questão 2a), escolha um dos 5
	produtos e crie duas novas instâncias idênticas a ele: uma com o mesmo código de barras e outra
	com o código diferente. Efetue a busca deste produto no vetor utilizando as duas instâncias e
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
