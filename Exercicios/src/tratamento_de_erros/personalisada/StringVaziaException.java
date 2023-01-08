package tratamento_de_erros.personalisada;

public class StringVaziaException extends RuntimeException{
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "a string está vazia";
	}
}
