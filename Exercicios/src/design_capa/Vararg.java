package design_capa;

public class Vararg {
	
	public static int somar(int... valores) {
		int result=0;
		for(int valor: valores) {
			result+=valor;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		System.out.println(Vararg.somar(1, 4, 7, 9));
	}
}
