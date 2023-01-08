package estruturas_de_controle;

public class ForAninhado {
	public static void main(String[] args) {
		
		int nRepeticoes = 0;
		
		for(int i = 1;i <= 10;i++) {
			
			for(int j = 1; j<=10;j++) {
				System.out.printf("[%d %d]",i,j);
				nRepeticoes++;
			}
			System.out.println();
		}
		System.out.println(nRepeticoes);
	}
}
