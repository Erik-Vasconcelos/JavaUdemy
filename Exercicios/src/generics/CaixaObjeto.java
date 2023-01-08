package generics;

public class CaixaObjeto {
	public Object coisa;
	
	public Object abrir() {
		return coisa;
	}
	
	public void guardar(Object coisa) {
		this.coisa=coisa;
	}
}
