package tratamento_de_erros;

public class Checada {
	//Precisa explicitamente em todos os lugares onde chamo dizer que lanca uma exceção
	
	static void erro1() throws Exception{
		throw new Exception();
	}
	
	static void met2() throws Exception{
		erro1();
	}
	
	static void met3() throws Exception {
		met2();
	}
	
	public static void main(String[] args) {
		try {
			Checada.met3();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
