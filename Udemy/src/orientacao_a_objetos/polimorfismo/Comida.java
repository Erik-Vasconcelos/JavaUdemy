package orientacao_a_objetos.polimorfismo;

import Arrays_E_Collections.Arrays.Usuario;

public abstract class Comida {
	/* para o usuário não poder instanciar uma comida generica
	Pessoa convidado = new Pessoa();
	Comida c1 = new Comida(0.23);
	convidado.comer(c1);
	tem que tornar a classe comida abstrata*/
	
	private double peso;
	
	Comida(double peso){
		setPeso(peso);
	}
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		if(peso>=0) {
			this.peso = peso;
		}
	}
	
	
}
