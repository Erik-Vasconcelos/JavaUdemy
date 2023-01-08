package orientacao_a_objetos.exercicios.ingresso;

public class Ingresso {
	private String tipoIngresso;
	private int valor= 50;
	
	public int imprimeValor() {
		return valor;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return getTipoIngresso()+" "+imprimeValor();
	}

	public String getTipoIngresso() {
		return tipoIngresso;
	}

	public void setTipoIngresso(String tipoIngresso) {
		this.tipoIngresso = tipoIngresso;
	}
	
	
}
