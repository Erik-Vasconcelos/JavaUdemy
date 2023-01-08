package br.edu.ifrn.cb.modelo;

import java.util.Date;

public class Cadastro {
//	public Cadastro(String nome, String cPF, Date dataNascimento, String email, String login) {
//		// TODO Auto-generated constructor stub
//	}
	public static String cadastrar(String nome, String cPF, Date dataNascimento, String email, String login) {
		Cliente cliente = new Cliente(nome, cPF, dataNascimento, email);
		Conta contaCli =  new Conta(cliente, login);
		return contaCli.getNumeroConta()+"";
	}

	
}
