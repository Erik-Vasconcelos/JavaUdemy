package orientacao_a_objetos.polimorfismo;

public class Jantar {
	public static void main(String[] args) {
		Pessoa convidado =new Pessoa(98.9);
		
		Feijao comida1 =new Feijao(0.34);
		Arroz comida2 = new Arroz(0.13);
		Sorvete comida3 =new Sorvete(0.56);
		
		System.out.println(convidado.getPeso());
		
		convidado.comer(comida1);
		System.out.println(convidado.getPeso());
		
		convidado.comer(comida2);
		System.out.println(convidado.getPeso());
		
		convidado.comer(comida3);
		System.out.println(convidado.getPeso());
		
		convidado.comer(comida2);
		System.out.println(convidado.getPeso());
		
	}
}
