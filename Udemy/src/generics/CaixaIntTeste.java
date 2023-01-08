package generics;

public class CaixaIntTeste {
	public static void main(String[] args) {
		CaixaInt caixaInteira =new CaixaInt();
		caixaInteira.guardar(3);
		
		System.out.println(caixaInteira.abrir());
	}
}
