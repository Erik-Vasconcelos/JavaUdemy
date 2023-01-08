package caixa_eletronico.br.com.inter.ce.modelo;

import caixa_eletronico.br.com.inter.ce.excecao.ValorInsuficienteException;

public class CaixaEle {
	private Conta conta;
	
	public CaixaEle(Conta conta) {
		this.conta =conta;
	}
	public String sacar(double valor) throws ValorInsuficienteException {
		
		if(conta.getSaldo() -valor >=0) {

			conta.atualizarValor(-valor);
			return contaNotas(valor);
		}else {
			throw new ValorInsuficienteException();
		}
	}
	
	public void  depositar(double valor) {
		Double v =validarValor(valor);
		conta.atualizarValor(valor);
		//conta.setSaldo(conta.getSaldo()+valor);
	}
	
	private double validarValor(double numero) throws RuntimeException {
		if(numero > 0) {
			return numero;
		}else {
			throw new RuntimeException();
		}
	}
	
	public String contaNotas(double valor) {
		Nota n= new Notas100();
		//n.calcula(valor);
		n.calcula(n.calcula(valor));
		int notasCe=n.quant;
		int notasCin =n.quant;
		
		/*int notasCe = (int)valor/100;
		valor-=notasCe*100;
		valor-=notasCin*50;*/
		
		
		return "Notas de 100: "+notasCe+" Notas Cin: "+notasCin;
	}
	
	public String mostraSaldo() {
		return String.format("O seu saldo agora é de R$%.2f",conta.getSaldo());
	}
	
	void sair() {
		
	}
	
}
