package br.edu.ifrn.cb.modelo;

public class LoginInvalidoException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Login invalido";
	}
}
