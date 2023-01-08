package estruturas_de_controle;

public class SwitchCase {
	public static void main(String[] args) {
		
		
		//Sem o uso do Break!
		String serie ="sétima";
		
		switch(serie.toLowerCase()) {
		case "sétima":
			System.out.println("Sabe equação do 2 grau");
		case "sexta":
			System.out.println("Sabe equação do 1 grau");
		case "quinta":
			System.out.println("Sabe ler textos");
		case "quarta":
			System.out.println("Sabe Ler frases");
		case "terceira":
			System.out.println("Sabe ler palavras");
		case "segunda":
			System.out.println("Sabe juntar sílabas");
		case "primeira":
			System.out.println("Sabe o alfabeto");
	
		}
	}
}
