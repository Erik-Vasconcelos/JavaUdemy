package tratamento_de_erros.personalizada_b;

@SuppressWarnings("serial")
public class NumeroForaIntervaloException extends Exception{
	//Criando a Exce��o personalizada Verificada
	//tornando o construtor privado para o objeto n�o ser instanciado
	private String nomeAtributo;
	
	//construtor
	public NumeroForaIntervaloException(String nomeAtributo) {
		this.nomeAtributo = nomeAtributo;
	}
	@Override
	public String getMessage() {
		return String.format("O atributo '%s' est� fora do intervalo ",nomeAtributo);
	}
	
}
