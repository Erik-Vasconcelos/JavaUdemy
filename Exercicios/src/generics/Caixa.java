package generics;

public class Caixa <T>{
	
	public T coisa;
	
	public void guardar(T coisa) {
		this.coisa=coisa;
	}
	
	public T abrir() {
		return coisa;
	}
}
