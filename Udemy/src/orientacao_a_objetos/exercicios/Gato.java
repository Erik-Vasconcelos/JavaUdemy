package orientacao_a_objetos.exercicios;

public class Gato extends Animal {
	
	
	public Gato(String nome) {
		super(nome);
		
	}
	
	@Override
	String caminha() {
		// TODO Auto-generated method stub
		return getNome()+" "+ super.caminha();
	}
	
	public String mia() {
		return "Miou";
	}
}
