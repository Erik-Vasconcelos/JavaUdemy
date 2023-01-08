package br.com.cod3r.exerciciossb.model.entities;

public class Cliente {

	private int idade;
	private String nome;
	private String cpf;
	
	public Cliente(int idade, String nome, String cpf) {
		super();
		this.idade = idade;
		this.nome = nome;
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
	
	
	
}
