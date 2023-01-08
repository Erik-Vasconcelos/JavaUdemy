package orientacao_a_objetos.exercicios;

public class Cachorro extends Animal {

	public Cachorro(String nome) {
		super(nome);
		
	}
	
	@Override
	java.lang.String caminha() {
		
		return this.getNome()+" "+super.caminha();
	}
	
	public String late() {
		return "latiu";
	}
}
