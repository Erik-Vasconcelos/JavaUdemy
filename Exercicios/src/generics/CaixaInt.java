package generics;
	/*Mesmo com heren�a voc� pode n�o resolver o tipo e passar essa 
	 * responsabilidade para quem for istanciar a classe que est� herdando, 
	 * nesse caso a CaixaInt*/

/*public class CaixaInt<T> exteds Caixa<T>{} ou seja aqui o que � recebido na instancia��o 
 * da CaixaInt � passaddo para o generics de Caixa*/


//Nesse caso a CaixaInt est� herdando de Caixa e no generics estou amarrando o tipo que posso receber
//A caixa int est� resolvendo o tipo generico e ela n�o ter� tipo generico associado

public class CaixaInt extends Caixa<Integer>{
	
}

