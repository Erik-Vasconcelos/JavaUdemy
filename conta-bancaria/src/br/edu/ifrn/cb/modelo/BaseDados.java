package br.edu.ifrn.cb.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BaseDados {
	
	private static Map<Integer, Conta> contas = new HashMap<>();
	public static List<ContaObservador> observadores = new ArrayList<>();
	
	public static void cadastrar(Conta conta) {
		contas.put(conta.getNumeroConta(), conta);
	}
	
	public static Conta logar(int numero, String login) {
		Conta cont = verificarConta(numero);
		if(cont instanceof Conta) {
			if(cont.validarLogin(login)) {
				return cont;
			}
		}
		throw new LoginInvalidoException();
	}
	
	public static void atualizar(Conta conta) {
		contas.put(conta.getNumeroConta(), conta);
	}
	
	public boolean setTranferencia(Conta pagador, int numeroConta, double valor) {
		Conta bene =verificarConta(numeroConta);
		if(bene instanceof Conta) {
			bene.receberTranferencia(valor);
			return true;
		}else {
			return false;
		}
	}
	
	public static Conta verificarConta(int numeroConta) {
		for(Entry<Integer, Conta> cont:contas.entrySet()) {
			if(cont.getKey().equals(numeroConta)) {
				return cont.getValue();
			}
		}
		return null;
	}
}
