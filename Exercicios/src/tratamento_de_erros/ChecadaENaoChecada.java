package tratamento_de_erros;

public class ChecadaENaoChecada {
	public static void main(String[] args) throws Exception {
		
		try {
			geraErro1();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			geraErro2();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Fim! ");
		
		
		/* ex de erro :
		geraErro2();*/
		
		/*Posso ignorar o tratamento de erros dizendo que o metodo main tambem
		 *  vai lan�ar um erro > main() throws Exception() {*/
		
	}
	
	
	//N�o checada
	static void geraErro1() {
		throw new RuntimeException("Ocorreu o erro 1");
	}
	
	//checada ou verificada
	//Preciso explicitamente dizer que ele vai lan�ar uma exce��o
	//sendo assim quando chamarmos o m�todo obrigatoriamente precisa ser tratada
	static void geraErro2() throws Exception{
		throw new Exception("Ocorreu o erro 2");
	}
	
	
}
