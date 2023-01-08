package tratamento_de_erros.personalizada_b;

@SuppressWarnings("serial")
public class StringVaziaException extends Exception {
	//Criando a Exce��o personalizada Verificada
	private String nomeAtributo;
	
	public StringVaziaException(String nomeAtributo) {
		this.nomeAtributo =nomeAtributo;
	}
	
	@Override
	public String getMessage() {
		return String.format("O Atributo '%s' est� vazio ", nomeAtributo);
	}
	
}
