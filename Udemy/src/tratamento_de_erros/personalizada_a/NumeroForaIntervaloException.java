package tratamento_de_erros.personalizada_a;
//Criando a Exceção personalizada

/*Udemy-Java 2022
Criado por Erik Vasconcelos em 13 de abr. de 2022*/

@SuppressWarnings("serial")
public class NumeroForaIntervaloException extends RuntimeException{
	
	private String nomeAtributo;
	
	public NumeroForaIntervaloException(String nomeAtributo) {
		this.nomeAtributo = nomeAtributo;
	}
	//Reescrevendo o método
	@Override
	public String getMessage() {
		return String.format("O atributo '%s' está fora do intervalo ",nomeAtributo);
	}
}
