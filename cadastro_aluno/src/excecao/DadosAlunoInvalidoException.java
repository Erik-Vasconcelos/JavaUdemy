package excecao;

public class DadosAlunoInvalidoException extends RuntimeException {
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Os dados do aluno estão inválidos";
	}
}
