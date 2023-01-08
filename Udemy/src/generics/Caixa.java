package generics;

public class Caixa <T>{
	/*na hora da criacao deo objeto, o mesmo pode ser instanciado com o generics
	CaixaGenerica <String> caixa = new CaixaGenerica<>(); */
	
	private T coisa;

	public T abrir() {
		return coisa;
	}

	public void guardar(T coisa) {
		this.coisa = coisa;
	}
}
