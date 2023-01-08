package stream_api;

public class Pessoa {
	String nome;
	int idade;
	
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	@Override
	public String toString() {
		if(idade>=60) {
			return "Parabens você já é um veterano\n" +"Nome: "+nome+" idade: "+idade;
		}
		return "Nome: "+nome+" idade: "+idade;
	}
	
	
	
}
