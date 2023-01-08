package tratamento_de_erros.exercicios;

public class Tranferencia {
	
	public static void TestaSaldoValor(double saldo, double valor) throws SaldoInsuficienteException {
		if(saldo < valor) {
			throw new SaldoInsuficienteException();
		}else {
			System.out.println("Operação realizada com sucesso! ");
		}
	}
	
}
