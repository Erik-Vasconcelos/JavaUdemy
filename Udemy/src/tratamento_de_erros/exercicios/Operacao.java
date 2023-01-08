package tratamento_de_erros.exercicios;

public class Operacao {
	public static void main(String[] args) {
		try {
			Tranferencia.TestaSaldoValor(20, 40);
			
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
