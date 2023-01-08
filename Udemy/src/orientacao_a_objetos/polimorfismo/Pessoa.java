package orientacao_a_objetos.polimorfismo;

public class Pessoa {
	private double peso;
	
	Pessoa(double peso){
		setPeso(peso);
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		if(peso>0 && peso<=150) {
			this.peso = peso;
		}
	}
	
	public void comer(Comida comida) {
		this.peso+=comida.getPeso();
	}
	
	
}
