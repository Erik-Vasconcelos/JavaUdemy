package tratamento_de_erros;

public class ChrecadaVsNaoChecada {
	public static void main(String[] args) {
		
		try {
			geraErro1();
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		/*Posso Ignorar o erro 2 e n�o trata-l� colocando 
		na assinatura do m�todo main o throws Exeption e 
		assim voc� deixa a responsabilidade para o outro m�todo
		 trata-l�, mas como o m�todo main � o primeiro ele
		  simplismente vai sair do seu programa de forma bruta*/
		
		try {
			geraErro2();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Fim!");
		
	}
	
	//Exce��o N�O checada ou N�O verificada 
	static void geraErro1() {
		throw new RuntimeException("Ocorreu o erro #01! ");
	}
	
	
	//Exce��o checada ou verificada 
	static void geraErro2() throws Exception{
		throw new Exception("Ocorreu o erro #02! ");
	}
}
