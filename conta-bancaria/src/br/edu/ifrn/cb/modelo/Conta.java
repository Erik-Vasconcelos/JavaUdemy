package br.edu.ifrn.cb.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class Conta implements ContaObservador{
	private final int numeroConta = NumeroConta.gerarNumeroConta();
	private String login;
	private double saldo= 0.0;
	@SuppressWarnings("unused")
	private Cliente cliente;
	private BaseDados banco;
	
	public static List<ContaObservador> observadores = new ArrayList<>();
	
	
	@SuppressWarnings("static-access")
	public Conta(Cliente cliente, String login) {
		banco.cadastrar(this);
		this.cliente = cliente;
		this.login= login;
		
	}
	
	public void registrarObservador(ContaObservador observer) {
		observadores.add(observer);
	}
	
	public void notificarObservador(Operacao operacao) {
		observadores.stream().forEach(o -> o.atualizacaoOcorreu(operacao));
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	
	public void atualizarLogin(String login, String novoLogin) {
		if (this.login.equals(login)) {
			this.login=novoLogin;
		}
	}
	 
	public void processaOperacao(Operacao operacao, double valor, int nuConta) {
		
		switch (operacao) {
		case SACAR:
			sacar(valor);
			atualizacaoOcorreu(operacao);
			break;
			
		case DEPOSITAR:
			depositar(valor);
			atualizacaoOcorreu(operacao);
			break;
		case TRANFERIR:
			transferir(nuConta, valor);
			atualizacaoOcorreu(operacao);
			break;
		case RECEBERTRANFE:
			receberTranferencia(valor);
			atualizacaoOcorreu(operacao);
			break;
		default:
			
		}
	}
	

	public void receberTranferencia(double valor) {
		if(validar(Operacao.RECEBERTRANFE, valor)) {
			this.saldo+=valor;
		}
	}
	
	private void sacar(double valor) {
		if(validar(Operacao.SACAR, valor)) {
			this.saldo -=valor;			
		}else {
			throw new SaldoInsuficienteException();
		}
		
	}
	
	void depositar(double valor) {
		if(validar(Operacao.DEPOSITAR, valor)) {
			this.saldo +=valor;			
		}
	}
	
	void transferir(int numeroConta, double valor) {
		if(validar(Operacao.TRANFERIR, valor)) {
			banco.setTranferencia(this, numeroConta, valor);
			this.saldo-=valor;
		}else {
			throw new SaldoInsuficienteException();
		}
	}
	
	
	private boolean validar(Operacao op ,double valor) {
		
		if(op==Operacao.SACAR || op==Operacao.TRANFERIR) {
			return this.saldo-valor>=0;
		}
		else if(op==Operacao.DEPOSITAR || op == Operacao.RECEBERTRANFE) {
			if (valor >0) {
				return true;
			}
			
		}return false;
		
	}
	public boolean validarLogin(String login) {
		if(login.equals(this.login)) {
			return true;
		}else {
			return false;
		}
	}

	private boolean validarEntradaLogin(String login) {
		if(!login.isEmpty() && login!= null && login.length()>5) {
			return true;
		}
		return false;
	}

	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Cliente getCliente() {
		return cliente;
	}

	@Override
	
	public void atualizacaoOcorreu(Operacao operacao) {
		switch (operacao) {
		case SACAR:case TRANFERIR:case DEPOSITAR: case RECEBERTRANFE:
			
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + operacao);
		}
	}

	
}
