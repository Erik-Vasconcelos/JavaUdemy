package br.com.marttech.sg.model.excecao;

public class DadosInvalidosException extends RuntimeException{
	@Override
	public String getMessage() {
		return "O(s) dado(s) do usuário estão inválidos";
	}

}
