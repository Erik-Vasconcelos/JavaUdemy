package br.edu.ifrn.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.edu.ifrn.cm.excecao.ExplosaoException;
import br.edu.ifrn.cm.excecao.SairException;
import br.edu.ifrn.cm.modelo.Tabuleiro;

public class TabuleiroConsole {
	private Tabuleiro tabuleiro;
	private Scanner leitor = new Scanner(System.in);
	
	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro=tabuleiro;
		
		executaJogo();
		// TODO Auto-generated constructor stub
	}

	private void executaJogo() {
		boolean continuar =true;
		while(continuar) {
			cicloDoJogo();
			try {
				
				System.out.println("Deseja continuar (S/n) ");
				String resposta =leitor.nextLine();
				
				if("n".equalsIgnoreCase(resposta)){
					continuar =false;
				}else {
					tabuleiro.reiniciar();
				}
			}catch(SairException e) {
				System.out.println("Tchau!!");
			}finally {
				leitor.close();
			}
			
		}
	}

	private void cicloDoJogo() {
		
		try {
			while(!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				String digitado = capturarValorDigitado("Digite (x, y): ");
				
				Iterator<Integer> xy =Arrays.stream(digitado.split(","))
						.map(e-> Integer.parseInt(e.trim())).iterator();
				
				digitado = capturarValorDigitado("1- Abrir, 2- (Des)Marcar");
				if("1".equals(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				}else if("2".equals(digitado)) {
					tabuleiro.alterarMarcacao(xy.next(), xy.next());
				}
			}
			
			System.out.println(tabuleiro);
			System.out.println("Você ganhou!!!");
		}catch (ExplosaoException e ) {
			System.out.println("Você perdeu!!!");
		}
		
	}
	private String capturarValorDigitado(String texto) {
		System.out.println(texto);
		String digitado= leitor.nextLine();
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();		
		}
		return digitado;
		
	}
}
