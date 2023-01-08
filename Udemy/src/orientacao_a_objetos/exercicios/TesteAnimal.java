package orientacao_a_objetos.exercicios;

public class TesteAnimal {

	public static void main(String[] args) {
		Gato g = new Gato("Garfield");
		Gato g1 = new Gato("Miminho");
		
		Cachorro c = new Cachorro("Bob");
		
		System.out.println(c.caminha()); 
		
		System.out.println(g.caminha()); 
		
		System.out.println(g.mia()); 
		System.out.println(c.late()); 
		
		System.out.println(g1.caminha()); 
		
	}

}
