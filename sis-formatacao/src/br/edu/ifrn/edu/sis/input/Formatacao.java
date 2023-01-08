package br.edu.ifrn.edu.sis.input;

import br.edu.ifrn.edu.sis.input.interno.OperacoesFormat;

public class Formatacao {

	private OperacoesFormat format = new OperacoesFormat();

	public String formatar(double valor) {
		return format.formatar(valor);
	}
	
}
