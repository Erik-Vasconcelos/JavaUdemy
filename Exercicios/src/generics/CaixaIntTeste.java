package generics;

public class CaixaIntTeste {
	public static void main(String[] args) {
		//A classe CaixaInt ja definiu o Tipo na hora da herança
		
		CaixaInt c = new CaixaInt();
		c.guardar(89);
		System.out.println(c.abrir());
		
		
	}
}
