package tratamento_de_erros.personalizada_a;
//Criando a Exce��o personalizada

/*Udemy-Java 2022
Criado por Erik Vasconcelos em 13 de abr. de 2022*/ 

@SuppressWarnings("serial")
public class StringVaziaException extends RuntimeException {
	//Criando a Exce��o personalizada
	private String nomeAtributo;
	
	public StringVaziaException(String nomeAtributo) {
		this.nomeAtributo =nomeAtributo;
	}
	
	@Override
	public String getMessage() {
		return String.format("O Atributo '%s' est� vazio ", nomeAtributo);
	}
	
}
