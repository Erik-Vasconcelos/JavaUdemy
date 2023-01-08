package br.com.marttech.sg.model.perfis.abstracts;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import br.com.marttech.sg.model.dados.concreto.EnderecoServidor;
import br.com.marttech.sg.model.dados.concreto.Nota;
import br.com.marttech.sg.model.dados.concreto.TelefoneServidor;
import br.com.marttech.sg.model.perfis.enuns.Cargo;
import br.com.marttech.sg.model.perfis.enuns.Permissao;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING, length = 2)
public abstract class Servidor extends Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double salario;
	
	@OneToOne(mappedBy = "servidor", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private TelefoneServidor telefone;
	
	@OneToOne(mappedBy = "servidor", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private EnderecoServidor endereco;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "cargo", nullable = false)
	private Cargo cargo;

	@Transient
	@OneToMany(mappedBy = "servidor", fetch = FetchType.LAZY)
	private List<Nota> anotacoes = new ArrayList<>();

	public Servidor() {
		super();
	}
	
	public Servidor(Long id, String nome, String email, Long matricula, Cargo cargo, Permissao permissao) {
		this.id = id;
		this.cargo = cargo;
		setPermissao(permissao);
	}

	public Servidor(String nome, String cpf, String email, Double salario, Cargo cargo , Permissao permissao, byte[] imagem) {
		super(nome, cpf, email, imagem);
		this.salario = salario;
		this.cargo = cargo;
		this.setPermissao(permissao);
		
	}
	
	public Servidor(String nome, String cpf, String email, Long matricula, String senha, Double salario, Cargo cargo , Permissao permissao, byte[] imagem) {
		super(nome, cpf, email, matricula, senha, imagem);
		this.salario = salario;
		this.cargo = cargo;
		this.setPermissao(permissao);
	}

	public Servidor(String nome, String cpf, TelefoneServidor telefone, String email, EnderecoServidor endereco,
			Double salario, Cargo cargo, Permissao permissao, byte[] imagem) {
		super(nome, cpf, email, imagem);
		this.endereco = endereco;
		this.telefone = telefone;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TelefoneServidor getTelefone() {
		return telefone;
	}

	public void setTelefone(TelefoneServidor telefone) {
		this.telefone = telefone;
	}

	public EnderecoServidor getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoServidor endereco) {
		this.endereco = endereco;
	}

	public List<Nota> getAnotacoes() {
		return anotacoes;
	}
	
}
