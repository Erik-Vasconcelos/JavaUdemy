
public class KmLitro {
	public static void main(String[] args) {
		// erikv 12 de jul. de 2022
		java.util.Scanner leitor = new java.util.Scanner(System.in);

		
		int totalKm = 0;
		int totalL = 0;
		
		int nViagem = 0;
		int km=0;
		while(km != -1) {
			
			System.out.println("DIgite Os quilometros que você fez: ");
			km= leitor.nextInt();
			if(km>1) {
				System.out.println("DIgite quantos litros você gastou: ");
				int litros = leitor.nextInt();
				totalKm += km;
				totalL +=litros;
				System.out.printf("Voce fez %.2f km/l nessa viagem", (km/litros)*1.0);
				System.out.printf("%nVoce consumiu o total de %d litros e fez um total de %d quilômetros%n", totalL, totalKm);
			}
		}
		
		leitor.close();
	}
}
