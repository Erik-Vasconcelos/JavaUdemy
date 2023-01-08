package br.com.marttech.sg.model.perfis.abstracts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.marttech.sg.model.dados.Endereco;
import br.com.marttech.sg.model.dados.Telefone;
import br.com.marttech.sg.model.perfis.enuns.Cargo;
import br.com.marttech.sg.model.perfis.enuns.Permissao;

@Entity
public abstract class Servidor extends Usuario {

	private Double salario;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "cargo", nullable = false)
	private Cargo cargo;

	public Servidor() {
		super();
	}

	
	public Servidor(String nome, String cpf, String email, Double salario, Cargo cargo , Permissao permissao) {
		super(nome, cpf, email);
		this.salario = salario;
		this.cargo = cargo;
		this.setPermissao(permissao);
		
	}

	public Servidor(String nome, String cpf, Telefone telefone, String email, Endereco endereco,
			Double salario, Cargo cargo, Permissao permissao) {
		super(nome, cpf, telefone, email, endereco);
		this.salario = salario;
		this.cargo = cargo;
		this.setPermissao(permissao);
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
}
