package br.com.cod3r.app.financeiro;

import java.util.ServiceLoader;

import br.com.cod3r.app.Calculadora;

public class Teste {
	
	public static void main(String[] args) {
		
		/*Este processo está sendo feito para o modulo 
		 * financeiro não dependa da implemnentação e sim da Interface 
		 * - No mudulo api voce presisará exportar o pacote onde tem a interface
		 * - No modulo calculo voce precisará que ele requira o modulo app.api 
		 * porque a CalculadoraImpl precisará implemetar a interface Calculadora 
		 * e no Build patch precisará criar a dependencia
		 * - Agora a CalculadoraImpl que é a classe irá implementar a interface 
		 * Calculadora que foi definida na api-publica
		 * - No modulo calculo você vai colocar o provides e em seguida a interface e 
		 * dizer que ele é provida com a implementacao CalculadoraImpl:
		 * provides Calculadora with CalculadoraImpl;
		 * - Agora no modulo app.finaceiro voce nao vai depender mais do app.calculo 
		 * que é a implmentacao e sim da api que tem a interface e tambem vai usar o 
		 * servico que é a interface dentro da aplicacao:
		 * 		uses br.com.cod3r.app.Calculadora;
		 * 
		 * -- Para voce Usar este sevico voce ira na hora da instanciacao passar a classe 
		 * ServiceLoader com o metodo load para procurar a sua interface.class e achar uma implementacao 
		 * que atenda a interface.
		 * O ServiceLoader é um servico que busca dentro do seu classpatch tem os modulo que voce nao depende
		 *  diretamente e esses modulo proveem uma implementacao para aquela interface, quem vai encontrar a 
		 *  implementacao é o ServiceLoader */
		
		
		Calculadora calc = ServiceLoader
				.load(Calculadora.class)
				.findFirst() //Trás o primeiro elemento
				.get();
		
		System.out.println(calc.soma(2, 3, 4));
		
//		OperacoesAritimeticas op = new OperacoesAritimeticas();
//		System.out.println(op.soma(3, 4, 5));
		
		
//		try {
//			Field fieldId = calc.getClass().getDeclaredFields()[0];
//			fieldId.setAccessible(true);
//			
//			fieldId.set(calc, "def");
//			System.out.println(fieldId.get(calc));
//			fieldId.setAccessible(false);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
	}
}
