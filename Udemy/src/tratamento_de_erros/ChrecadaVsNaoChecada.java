package tratamento_de_erros;

public class ChrecadaVsNaoChecada {
	public static void main(String[] args) {
		
		try {
			geraErro1();
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		/*Posso Ignorar o erro 2 e não trata-ló colocando 
		na assinatura do método main o throws Exeption e 
		assim você deixa a responsabilidade para o outro método
		 trata-lá, mas como o método main é o primeiro ele
		  simplismente vai sair do seu programa de forma bruta*/
		
		try {
			geraErro2();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Fim!");
		
	}
	
	//Exceção NÃO checada ou NÃO verificada 
	static void geraErro1() {
		throw new RuntimeException("Ocorreu o erro #01! ");
	}
	
	
	//Exceção checada ou verificada 
	static void geraErro2() throws Exception{
		throw new Exception("Ocorreu o erro #02! ");
	}
}
