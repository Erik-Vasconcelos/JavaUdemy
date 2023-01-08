package topicos_avancados;

public class Torre {
	
	public static void main(String[] args) {
		hanoi(1, 3, 2, 3);
	}
	
	private static void hanoi(int torreInicial, int torreDestino, int torreTemp, int discos) {
		
		if(discos == 1) {
			System.out.printf("%d -> %d\n", torreInicial, torreDestino);
			return;
		}
		
		hanoi(torreInicial, torreTemp, torreDestino, discos - 1);
		System.out.printf("%d -> %d\n", torreInicial, torreDestino);
		
		hanoi(torreTemp, torreDestino, torreInicial, discos - 1);
		
	}
	
	

}
