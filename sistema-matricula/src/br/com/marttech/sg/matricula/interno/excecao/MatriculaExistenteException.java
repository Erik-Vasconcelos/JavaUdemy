package br.com.marttech.sg.matricula.interno.excecao;

public class MatriculaExistenteException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "A matricula ja existe no banco de dados";
	}
	
}
