package br.com.cod3r.app.calculo;

import br.com.cod3r.app.Calculadora;
import br.com.cod3r.app.calculo.interno.OperacoesAritimeticas;

public class CalculadoraImpl implements Calculadora{

	private String id = "abc";
	
	private OperacoesAritimeticas opeAritimeticas = new OperacoesAritimeticas();

	public double soma(double... valores) {
		return opeAritimeticas.soma(valores);
	}
	
	/*public Class<Logger> getLogger(){
		return Logger.class;
	}*/
	
}
