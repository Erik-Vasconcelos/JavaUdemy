package br.edu.ifrn.cb.modelo;
import java.util.Date;

public class Cliente {
	private String nome;
	private final String CPF;
	private Date dataNascimento;
	private String email;
	//private Conta conta;
	
	public Cliente(String nome, String cPF, Date dataNascimento, String email) {
		this.nome = nome;
		CPF = cPF;
		this.dataNascimento = dataNascimento;
		this.email = email;
		//this.conta=conta;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*public Conta getConta() {
		return conta;
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
	}*/
	
	public String getCPF() {
		return CPF;
	}
	
}
