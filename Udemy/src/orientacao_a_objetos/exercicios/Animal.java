package orientacao_a_objetos.exercicios;

public class Animal {
	private String nome;
	private String raca;
	
	
	/*public Animal(){
		
	}*/
	public Animal(String nome){
		this.nome=nome;
	}
	
	
	String caminha() {
		return "Caminhando";
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
