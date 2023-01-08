package orientacao_a_objetos.exercicios.ingresso;

public class Vip extends Ingresso{
	
	private int valorAdicional = 20;
	
	public int imprimeValor() {
		return valorAdicional+super.imprimeValor();
		
	}

	public int getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(int valorAdicional) {
		this.valorAdicional += valorAdicional;
	}
	
	
}
