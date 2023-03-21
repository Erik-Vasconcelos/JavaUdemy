package br.com.ifrn.portal.revisaosb.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "O nome não poder ser vazio")
	private String nome;
	
	@NotBlank(message = "O email não poder ser vazio")
	private String email;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(int id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public Cliente(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
