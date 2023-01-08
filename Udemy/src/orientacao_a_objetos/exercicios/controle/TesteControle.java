package orientacao_a_objetos.exercicios.controle;

public class TesteControle {
	public static void main(String[] args) {
		MeuControle controle= new MeuControle();
		
		System.out.println(controle.isLigado());
		System.out.println(controle.getCanal());
		
		controle.liga();
		controle.aumentarCanal();
		controle.aumentarCanal();
		controle.aumentarCanal();
		controle.desliga();
		controle.aumentarCanal();
		
		System.out.println(controle.isLigado());
		System.out.println(controle.getCanal());
		
	}
}
