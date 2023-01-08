package br.com.cod3r.app.calculo.interno;

import java.util.Arrays;

public class OperacoesAritimeticas {

	public double soma(double... valores) {
		return Arrays.stream(valores).reduce(0.0, (t, v) -> t + v );
	}
}
