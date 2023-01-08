package excecao;

public class AtributoInvalidoException extends RuntimeException{

	 private String nomeStributo;

	public AtributoInvalidoException(String nomeStributo) {
		super();
		this.nomeStributo = nomeStributo;
		
	}
	 
	@Override
	public String getMessage() {
		return "O atributo " + nomeStributo + " � iv�lido de acordo com os parametros da aplica��o";
	}
}
