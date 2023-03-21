package br.edu.ifrn.portal.esb.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome nao pode ser nulo")
	private String nome;
	
	@Pattern(regexp = "(^\\d{3}.\\d{3}.\\d{3}-\\d{2}$)", message = "CPF inválido")
	private String cpf;
	
	@Min(value = 18, message = "O funcionário não pode ser menor de idade")
	private int idade;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Endereco endereco;
	
	public Funcionario() {

	}
	
	public Funcionario(String nome, String cpf, int idade, Endereco endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
