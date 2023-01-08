package caixa_eletronico.br.com.inter.ce;

import caixa_eletronico.br.com.inter.ce.modelo.CaixaEle;
import caixa_eletronico.br.com.inter.ce.modelo.Conta;

public class Teste {
	public static void main(String[] args) {
		Conta c1 = new Conta(45789, "Erik", 1000.00);
		
		CaixaEle c  = new CaixaEle(c1);
		try {
			
			System.out.println(c.sacar(550));
			//c.depositar(1245);
			
			System.out.println();
			System.out.println(c.mostraSaldo());
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}
}
