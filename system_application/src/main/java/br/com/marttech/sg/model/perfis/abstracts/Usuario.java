package br.com.marttech.sg.model.perfis.abstracts;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import br.com.marttech.sg.matricula.GeracaoMatricula;
import br.com.marttech.sg.model.perfis.enuns.Permissao;


/*@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 2, discriminatorType = DiscriminatorType.STRING)*/
@MappedSuperclass
public abstract class Usuario{
	
	@Column(nullable = false)
	private String nome;
	
	@Column(unique = true)
	private String cpf;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false, unique = true)
	private Long matricula;
	
	private Long login;
	
	private String senha;
	
	@Enumerated(EnumType.STRING)
	private Permissao permissao;
	
	private int nivelPermissao;
	
	@Column(length = 16777215)
	private byte[] imagem;
	
	public Usuario() {
	}
	
	public Usuario(String nome, String cpf, String email, byte[] imagem) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.imagem = imagem;
		this.matricula = GeracaoMatricula.gerar();
		setLogin(matricula);
		setSenha("@EENSINO" + cpf);
	}
	
	public Usuario(String nome, String cpf, String email, Long matricula, String senha, byte[] imagem) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.matricula = matricula;
		this.senha = senha;
		this.imagem = imagem;
		setLogin(matricula);
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
		nivelPermissao = permissao.getNivelPermissao();
	}
	
	public byte[] getImagem() {
		return imagem;
	}

	public int getNivelPermissao() {
		return nivelPermissao;
	}

	public void setNivelPermissao(int nivelPermissao) {
		this.nivelPermissao = nivelPermissao;
	}
	
}
