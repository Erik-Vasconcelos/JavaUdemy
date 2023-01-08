package orientacao_a_objetos.abstrato;

public class TesteAbstrato {
	public static void main(String[] args) {
		Cachorro c =new Cachorro();
		
		System.out.println(c.respirar());
		System.out.println(c.mamar());
		System.out.println(c.mover());
		
	}
}
