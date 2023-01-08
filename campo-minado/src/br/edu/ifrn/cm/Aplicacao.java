package br.edu.ifrn.cm;

import br.edu.ifrn.cm.modelo.Tabuleiro;
import br.edu.ifrn.cm.visao.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		Tabuleiro t = new Tabuleiro(6, 6, 3);
		
		//tabuleiro.alterarMarcacao(4,0);
		
		TabuleiroConsole tabu= new TabuleiroConsole(t);
		
		//System.out.println(t);
	}
}
