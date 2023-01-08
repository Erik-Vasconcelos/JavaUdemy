package com.exercicio.projetosb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Entity
public class Cliente {
	
	/**
	 * @author erikv
	 * @date 21:12:56 1 de nov. de 2022
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@Column(unique = true, length = 14, nullable = false)
	@NotBlank
	private String cpf;
	
	@Column(unique = true, nullable = false)
	@NotBlank
	private String email;
	
	@Max(100)
	private int idade;
	
	public Cliente() {
	}
	
	public Cliente(String nome, String cpf, String email, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
