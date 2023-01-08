package collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class C_Fila {
	/**
	 * @system_description Este programa tem como objetivo simular uma passagem de cliente 
	 *  em um caixa de supermecado, em que é implementado uma fila (Queue) para que os 
	 *  clientes possam passar as suas compras no caixa. Quando chega a ves do cliete 
	 *  é feito um comprimento junto com o nome dele e cada produto que é passado tem 
	 *  o nome e o preço apresentado na tela. No final é apresentado o valor total da 
	 *  compra do cliente.
	 * @date 11:39:26 14 de jul. de 2022
	 * @author erik vasconcelos
	 * @version 1.0 14 de jul. de 2022  
	 */
	
	private Queue<Pessoa> pessoas = new LinkedList<>();
	
	public Pessoa getProximo() {
		return pessoas.poll();
	}
	
	public String getMsgCompra(Pessoa pessoa) {
		String result = "";
		for (Produto produto : pessoa.getProdutos()) {
			result +=  produto.getNome()+" R$"+produto.getPreco()+"\n";
		}
		result += "Total : R$"+pessoa.getValorCompra(); 
		return result;
	}
	
	public boolean adicionarPessoas(List<Pessoa> pessoas) {
		for (Pessoa pessoa : pessoas) {
			if(pessoa !=  null) {
				this.pessoas.add(pessoa);
			}else {
				continue;
			}
		}
		return true; 
	}
	
	public boolean adicionarPessoa(Pessoa pessoa) {
		if(pessoa!= null) {
			return pessoas.add(pessoa);
		}else {
			return false;
		}
	}

	public Queue<Pessoa> getPessoas() {
		return pessoas;
	}
	
}
