package tratamento_de_erros;

public class Teste {
	public static void main(String[] args) {
		
		try {
			System.out.println(7/0);
			
		}catch(ArithmeticException e) {
			System.out.println("Ocorreu o erro: "+e.getMessage());
		}
	}
}
