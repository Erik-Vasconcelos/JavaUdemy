package tratamento_de_erros.exercicios;

public class AlturaInsuficienteException extends Exception{
	
	private String nomeAluno;
	private String mensagem;
	
	public AlturaInsuficienteException(Aluno_parque a) {
		mensagem  = String.format("O aluno %s não tem altura suficiente \n"
				+ "para poder entrar no brinquedo", a.nome);
	}
	@Override
	public String getMessage() {
		return mensagem;
	}
	
	
	
}
