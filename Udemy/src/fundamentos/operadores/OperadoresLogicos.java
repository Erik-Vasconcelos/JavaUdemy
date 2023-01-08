package fundamentos.operadores;

public class OperadoresLogicos {
	
	public static void main(String[] args) {
		boolean s1  = true;
		boolean s2 = false;
		
		System.out.println("Tabela E (AND)");
		System.out.println(s1 && s1);
		System.out.println(s1 && s2);
		System.out.println(s2 && s1);
		System.out.println(s2 && s2);
		
		System.out.println("\nTabela OU Exclusivo (XOR)");
		System.out.println(true ^ true);
		System.out.println(true ^ false);
		System.out.println(false ^ true);
		System.out.println(false ^ false);
		
		
	}
}
