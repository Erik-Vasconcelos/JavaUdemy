package tratamento_de_erros;

public class NaoChecada {
	//n�o precisa declarar que vai lan�ar um erro
	static void erro1() {
		throw new RuntimeException();
	}
	
	static void met2() {
		erro1();
	}
	
	static void met3() {
		met2();
	}
	
	
	public static void main(String[] args) {
		//O tratamento da exce��o n�o checada � opcional
		//NaoChecada.met3();
		
		try {
			NaoChecada.met3();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
}
