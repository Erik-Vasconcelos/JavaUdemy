package classes_e_metodos.DesafioDoModulo;

public class Jantar {
	public static void main(String[] args) {
		Comida c1 = new Comida("Arroz", 0.34);
		Comida c2 = new Comida("Feijão", 0.54);
		
		
		Pessoa p1 = new Pessoa("Erik", 75.5);
		System.out.println(p1.peso);
		p1.comer(c1);
		p1.comer(c2);
		
		System.out.printf("%s tem %.2f",p1.nome,p1.peso );
	}
}
