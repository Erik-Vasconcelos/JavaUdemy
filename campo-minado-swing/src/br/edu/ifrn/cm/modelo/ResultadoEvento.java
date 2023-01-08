package br.edu.ifrn.cm.modelo;

public class ResultadoEvento {
	private final boolean resultado;

	
	public ResultadoEvento(boolean resultado) {
		super();
		this.resultado = resultado;
	}

	public boolean isResultado() {
		return resultado;
	}
	
	public boolean isGanhou() {
		if(resultado == true) {
			return true;
		}
		return false;
	}
	
	
	
}
