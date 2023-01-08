package br.edu.ifrn.edu.sis.input.interno;

public class OperacoesFormat {

	public String formatar(double valor) {
		return 	String.format("R$%.2f", valor);
	}
}
