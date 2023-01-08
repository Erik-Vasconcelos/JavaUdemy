package excecao;

public class BaseDeDadosVaziaException extends RuntimeException{
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Não há nenhum aluno cadastrado no Banco de Dados\n";
	}
}
