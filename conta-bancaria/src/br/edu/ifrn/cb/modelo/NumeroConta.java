package br.edu.ifrn.cb.modelo;

public class NumeroConta {
	@SuppressWarnings("unused")
	private static int base=  2012013;
	
	private NumeroConta() {
		
	}
	
	public static int gerarNumeroConta() {
		return base++;	
	}
}
