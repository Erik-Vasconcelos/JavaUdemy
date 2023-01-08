package tratamento_de_erros.personalizada_a;
//Criando a Exceção personalizada

/*Udemy-Java 2022
Criado por Erik Vasconcelos em 13 de abr. de 2022*/ 

@SuppressWarnings("serial")
public class StringVaziaException extends RuntimeException {
	//Criando a Exceção personalizada
	private String nomeAtributo;
	
	public StringVaziaException(String nomeAtributo) {
		this.nomeAtributo =nomeAtributo;
	}
	
	@Override
	public String getMessage() {
		return String.format("O Atributo '%s' está vazio ", nomeAtributo);
	}
	
}
