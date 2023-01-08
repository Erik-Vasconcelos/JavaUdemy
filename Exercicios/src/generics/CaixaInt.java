package generics;
	/*Mesmo com herença você pode não resolver o tipo e passar essa 
	 * responsabilidade para quem for istanciar a classe que está herdando, 
	 * nesse caso a CaixaInt*/

/*public class CaixaInt<T> exteds Caixa<T>{} ou seja aqui o que é recebido na instanciação 
 * da CaixaInt é passaddo para o generics de Caixa*/


//Nesse caso a CaixaInt está herdando de Caixa e no generics estou amarrando o tipo que posso receber
//A caixa int está resolvendo o tipo generico e ela não terá tipo generico associado

public class CaixaInt extends Caixa<Integer>{
	
}

