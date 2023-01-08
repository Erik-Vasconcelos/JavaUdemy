package fundamentos.operadores;

public class OperadoresLogicosDesafio {
	public static void main(String[] args) {
		boolean trabalho1 = false;
		boolean trabalho2 = false;
		
		System.out.println("Vamos comprar a Tv de 50 pol: "+(trabalho1 && trabalho2));
		System.out.println("Vamos comprar a Tv de 32 pol: "+(trabalho1 ^ trabalho2));
		
		System.out.println("Vamos tomar sorvete no shopping: "+(trabalho1 || trabalho2));
		System.out.println("Voce ficou mais saudavel: "+ !(trabalho1 || trabalho2));
	}
		
}
