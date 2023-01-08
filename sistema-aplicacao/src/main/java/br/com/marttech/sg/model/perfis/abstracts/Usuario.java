package br.com.marttech.sg.model.perfis.abstracts;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import br.com.marttech.sg.matricula.GeracaoMatricula;
import br.com.marttech.sg.model.dados.Endereco;
import br.com.marttech.sg.model.dados.Telefone;
import br.com.marttech.sg.model.perfis.enuns.Permissao;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", length = 2, discriminatorType = DiscriminatorType.STRING)
public abstract class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(unique = true)
	private String cpf;
	
	
	@OneToOne(mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Telefone telefone;
	
	@Column(nullable = false)
	private String email;
	
	@OneToOne(mappedBy = "usuario",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Endereco endereco;
	
	@Column(nullable = false, unique = true)
	private Long matricula;
	
	private Long login;
	
	private String senha;
	
	@Enumerated(EnumType.STRING)
	private Permissao permissao;

	public Usuario() {
	}
	
	public Usuario(String nome, String cpf, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.matricula = GeracaoMatricula.gerar();
		setLogin(matricula);
		setSenha("@EERP" + cpf);
		
	}

	public Usuario(String nome, String cpf, Telefone telefone, String email,
			Endereco endereco) {
		this(nome, cpf, email);
		this.telefone = telefone;
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

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public Long getLogin() {
		return login;
	}

	public void setLogin(Long login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	@Override
	public String toString() {
		
		return "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email
				+ ", endereco=" + endereco + ", matricula=" + matricula + ", permissao=" + permissao + "]";
	}
	
	
	
}
