package excecao;

public class MatriculaInvalidaException extends RuntimeException {
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "A matricula informada não é válida!";
	}
}
