package fundamentos.operadores;

public class Ternario {
	public static void main(String[] args) {
		
		/*double media = 4.3;
		
		String resultadoParcial = media >= 5? "em recupera��o": "reprovado";
		
		// Pega o resultado da outra opera��o ternaria e o resultado final recebe caso o teste d� falso
		String resultadoFinal = media >= 7? "Aprovado": resultadoParcial;
		
		System.out.println(resultadoFinal);*/
		
		int idade = 61;
		
		//Opera��o para testar se a pessoa pode votar usando o operador tern�rio e compara��e l�gicas
		String resulParcial = idade <18 && idade >=16 || idade > 60 ?"Voto facultativo":"Voto Obrigat�rio";
		System.out.println(resulParcial);
		
		
	}
}
