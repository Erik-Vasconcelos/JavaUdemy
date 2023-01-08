package caixa_eletronico.br.com.inter.ce.modelo;

public class Conta {
	
	private final int nConta;
	private final String nomePessoa;
	private double saldo ;
	

	public Conta(int nConta, String nomePessoa, double saldo) {
		super();
		this.nConta = nConta;
		this.nomePessoa =nomePessoa;
		this.saldo = saldo;
	}
	
	void atualizarValor(double valor) {
		saldo +=valor;
		
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getnConta() {
		return nConta;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}
	
	
	
	
	
	
}
