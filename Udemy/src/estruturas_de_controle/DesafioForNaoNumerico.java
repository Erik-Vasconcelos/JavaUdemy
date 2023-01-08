package estruturas_de_controle;

public class DesafioForNaoNumerico {
	public static void main(String[] args) {
		String valor = "#";
		
		for(;!valor.equals("######");valor+="#") {
			System.out.println(valor);
		}
	}
	
}
