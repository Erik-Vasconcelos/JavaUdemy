package caixa_eletronico.br.com.inter.ce.modelo;

public class Nota {
	protected double valor;
	int quant;
	
	double calcula(double valor) {
		this.quant =(int) (valor / this.valor);
		return valor%this.valor;
		
	}
}
