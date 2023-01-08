package br.edu.ifrn.portal.sis.interacao;

import java.util.Scanner;

import br.edu.ifrn.edu.sis.input.Formatacao;

public class Teste {

	public static void main(String[] args) {
		Formatacao formatacao = new Formatacao();
		// erikv 14 de set. de 2022
		Scanner leitor = new Scanner(System.in);

		double valor = leitor.nextDouble();
		System.out.println(formatacao.formatar(valor));

		leitor.close();
		
	}
}
