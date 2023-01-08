package caixa_eletronico.br.com.inter.ce.excecao;

public class ValorInsuficienteException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Valor insuficiente!";
	}
}
