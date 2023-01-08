package classes_e_metodos;


//classe driver - classe condutora- orienta um objeto da classe Account indicando o que fazer 
public class AccauntTest {
	
	Accaunt ac;
	public static void main(String[] args) {
		Accaunt conta = new Accaunt("Tirineu");
		conta.deposit(200);
		System.out.println(conta.getSaldo());
		conta.displayAccount();
		
		try {
			conta.sacar(200);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		conta.displayAccount();
		
		System.out.println(conta.getSaldo());
		
		
		java.util.Scanner leitor = new java.util.Scanner(System.in);
		float f = (float) leitor.nextDouble();
		
		AccauntTest acco = new AccauntTest();
		System.out.println(acco.ac);
		
		/*public
		 * class
		 * new
		 * tipo variavel
		 * 
		 * float e double
		 * 15
		 * nextDouble
		 * modificador
		 * void
		 * nextLine()
		 * java.lang
		 * importacao
		 * 7
		 * %f
		 * primitivos e referencia
		 * 
		 * f - quem comeca com letara maúscula é classe
		 * v
		 * v
		 * f - so os tipos por referencia poder fazer isso
		 * f - as variaveis locais só são visíveis no escopo do método
		 * v
		 * f -somente as variaveis de intancia sao inicializadas por padrão
		 * v
		 * v
		 * v
		 * f - o literal padrão de ponto flutuante é o double
		 * 
		 * variável local so é visível dentro do método
		 * variavel de instancia é visivel para toda a classe
		 * 
		 * o parametro é um valor necessário para o método realizar alguma tarefa.
		 *  argumentos sao os valores passados para os parametro correpondetes no metodo
		 *  
		 *  EX:
		 * 		public int soma((int a, int b)//parametro) {
					return a+b;
				}
				
		 * 		soma((4, 6)//argumentos);
		 * 
		 * */
			
		
		}
	


}
