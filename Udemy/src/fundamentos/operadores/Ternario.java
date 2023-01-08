package fundamentos.operadores;

public class Ternario {
	public static void main(String[] args) {
		
		/*double media = 4.3;
		
		String resultadoParcial = media >= 5? "em recuperação": "reprovado";
		
		// Pega o resultado da outra operação ternaria e o resultado final recebe caso o teste dê falso
		String resultadoFinal = media >= 7? "Aprovado": resultadoParcial;
		
		System.out.println(resultadoFinal);*/
		
		int idade = 61;
		
		//Operação para testar se a pessoa pode votar usando o operador ternário e comparaçõe lógicas
		String resulParcial = idade <18 && idade >=16 || idade > 60 ?"Voto facultativo":"Voto Obrigatório";
		System.out.println(resulParcial);
		
		
	}
}
