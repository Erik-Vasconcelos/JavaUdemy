package tratamento_de_erros.personalisada;

@SuppressWarnings("serial")
public class NumeroForaDoImntervaloException extends RuntimeException{
	
	@Override
	public String getMessage() {
		return "O número está fora do intervalo! ";
	}	
}
