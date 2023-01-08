import java.util.Scanner;

public class EstruturasControle {
	public static void main(String[] args) {
		
		// erikv 12 de jul. de 2022
		Scanner leitor = new Scanner(System.in);

		

		int total =0;
		int qAlu = 0;
		
		int valorDigitado =0;
		while(valorDigitado!=999 ) {
			System.out.println("Digite a nota:");
			valorDigitado = leitor.nextInt();
			if(valorDigitado >0 && valorDigitado <=10) {
				total+=valorDigitado;
				qAlu++;
			}
		}
		
		System.out.println(total/qAlu);
		leitor.close();
	}
}
