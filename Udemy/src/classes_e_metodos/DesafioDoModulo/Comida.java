package classes_e_metodos.DesafioDoModulo;

public class Comida {
	String nome;
	public String getNome() {
		return nome;
	}

	public double getPeso() {
		return peso;
	}

	double peso;
	
	public Comida(String nome, double peso){
		this.nome=  nome;
		this.peso =peso;
		
	}
	
}
