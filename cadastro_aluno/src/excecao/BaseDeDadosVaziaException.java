package excecao;

public class BaseDeDadosVaziaException extends RuntimeException{
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "N�o h� nenhum aluno cadastrado no Banco de Dados\n";
	}
}
