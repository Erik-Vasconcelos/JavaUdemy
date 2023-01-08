package orientacao_a_objetos.abstrato;

public abstract class Animal {
	/*uma classe abstrata pode deixar a responsabilidade da
	classe filha implementar algum m�todo, ou  seja a classe abstrata pode estar
	inacabada/ ter metodos abstratos*/
	
	public String respirar() {
		return "Usando Oxig�nio";
	}
	
	public abstract String mover();
}
