package tratamento_de_erros.exercicios;

@SuppressWarnings("serial")
public class SaldoInsuficienteException extends Exception{
	
	public SaldoInsuficienteException() {
		//System.out.println("Saldo insuficiente para realizar a operação ");
	}
	@Override
	public String getMessage() {
		return "Saldo insuficiente para realizar a operação ";
	}
}
