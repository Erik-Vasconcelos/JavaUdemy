package collections;

import java.util.ArrayList;
import java.util.List;

import classes_e_metodos.Date;

public class C_FilaTest {
	public static void main(String[] args) {
		
		C_Fila filaCaixa = new C_Fila();
		
		List<Produto> lista1 = new ArrayList<>();
		lista1.add(new Produto("Caneta", 6.5));
		lista1.add(new Produto("Borracha", 3.50));
		
		List<Produto> lista2 = new ArrayList<>();
		lista2.add(new Produto("Livro ", 245.67));
		lista2.add(new Produto("Caderno", 56.34));
		
		List<Produto> lista3 = new ArrayList<>();
		lista3.add(new Produto("Impressora", 659.45));
		lista3.add(new Produto("Biscoito", 8.69));
		
		Pessoa p1 = new Pessoa("Erik", new Date(24, 01, 2005),lista1);
		Pessoa p2  = new Pessoa("Samuel", new Date(15, 02, 1968), lista2);
		Pessoa p3  = new Pessoa("Tirineu", new Date(31, 06, 1980), lista1 );
		Pessoa p4  = new Pessoa("Carlos", new Date(01, 02, 2001), lista3);
		Pessoa p5  = new Pessoa("Weverton", new Date(29, 9, 2004), lista2);
		
		ArrayList<Pessoa> pesso = new ArrayList<>();
		pesso.add(p1);
		pesso.add(p2);
		pesso.add(p3);
		pesso.add(p4);
		pesso.add(p5);
		
		filaCaixa.adicionarPessoas(pesso);
		
		while(filaCaixa.getPessoas().size() !=0) {
			Pessoa p = filaCaixa.getProximo();
			System.out.println("Olá, bem vindo "+p.getNome());
			System.out.println(filaCaixa.getMsgCompra(p));
			System.out.println();
		}

		
	}
}
