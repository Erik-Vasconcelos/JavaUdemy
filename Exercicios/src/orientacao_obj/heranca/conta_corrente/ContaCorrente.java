package orientacao_obj.heranca.conta_corrente;

import java.util.Scanner;

/* Crie uma classe para representar uma conta corrente, com métodos para depositar uma quantia, sacar
	uma quantia e obter o saldo. Para cada saque será debitada também uma taxa de operação equivalente à
	0,5% do valor sacado. Crie, em seguida, uma subclasse desta classe anterior para representar uma conta
	corrente de um cliente especial. Clientes especiais pagam taxas de operação de apenas 0,1% do valor
	sacado. Faça testes com as duas classes e verifique seus resultados.*/

public class ContaCorrente {
	private double saldo;
	protected double taxa = 0.05;
	Scanner leitor = new Scanner(System.in);
	
	
	public ContaCorrente(double saldo) {
		if(saldo > 0) {
			this.saldo = saldo;
		}
		exectar();
	}
	protected ContaCorrente(double saldo, double taxa) {
		if(saldo > 0) {
			this.saldo = saldo;
			this.taxa = taxa;
		}
		exectar();
	}
	
	
	void exectar() {
		System.out.println("Bem Vindo ao programa!!!\n");
		String op="";
		
		while(!"sair".equalsIgnoreCase(op)) {
			System.out.println("\nD - Depoistar\nS - Sacar\nE - Extrato\nSair - Sair");
			op = leitor.next();

			if("d".equalsIgnoreCase(op)) {
				System.out.println("Digite o valor do depósito: ");
				double valor = leitor.nextDouble();
				depositar(valor);
			}
			else if("s".equalsIgnoreCase(op)) {
				System.out.println("Digite o valor do Saque: ");
				double valor = leitor.nextDouble();
				sacar(valor);
			}
			else if("e".equalsIgnoreCase(op)) {
				System.out.println("Seu saldo atual é de: "+obterSaldo());
			}
			else if("sair".equalsIgnoreCase(op)) {
				System.out.println("Finalizando...");
				
			}else {
				System.err.println("Opção inválida! ");
			}
			
			
		}
		leitor.close();
	}
	
	void depositar(double valor) {
		if(valor >0) {
			this.saldo += valor;
		}
	}
	
	void sacar(double valor) {
		if(this.saldo-(valor +valor*this.taxa)>=0) {
			this.saldo -= (valor +valor*this.taxa);
		}else {
			System.out.println("Saldo insuficiente");
		}
	}
	
	double obterSaldo() {
		return this.saldo;
	}
	
	public static void main(String[] args) {
	
		ContaCorrente conta = new ContaCorrente(1500);
		
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	
	
	
}
