package br.edu.ifrn.cb.modelo;


@SuppressWarnings("serial")
public class SaldoInsuficienteException extends RuntimeException{
	@Override
	public String getMessage() {
		return "O saldo disponivel na conta n�o � suficiente para realizar a opera��o";
	}

}
