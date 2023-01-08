package classes_e_metodos;

public class Accaunt {
	
	/**
	 *  Este programa tem como objetivo simular uma conta bancária
	 *  em que o usuário pode depositar, sacar e consultar o saldo da sua conta.
	 *  Data de Criacao:12/07/2022
	 *  
	 * @author erik vasconcelos
	 */
	
	private String nomeCliente;
	private double saldo;
	
	public Accaunt() {
		// TODO Auto-generated constructor stub
	}
	
	public Accaunt(String nomeCliente) {
		super();
		this.nomeCliente = nomeCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public double getSaldo() {
		return saldo;
	}
	public void deposit(double saldo) {
		this.saldo += saldo;
	}
	
	public void sacar(double valor) {
		//Validação do valor para realizar a operação
		if(valor >0 && valor<=saldo) {
			this.saldo-=valor;
		}else {
			throw new RuntimeException("Valor inválido ou \nsaldo insuficiente");
		}
	}
	
	public void displayAccount() {
		System.out.printf("%s balance: $%.2f %n ", this.getNomeCliente(),
				this.getSaldo());
	}
}
