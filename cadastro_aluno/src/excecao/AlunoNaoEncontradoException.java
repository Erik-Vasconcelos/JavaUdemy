package excecao;

public class AlunoNaoEncontradoException extends RuntimeException{
	@Override
	public String getMessage() {
		return "O Aluno n�o foi encontrado no Banco de dados";
	}
	
}
