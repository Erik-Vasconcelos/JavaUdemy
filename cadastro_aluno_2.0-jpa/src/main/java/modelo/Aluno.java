package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(nullable = false, length = 14, unique = true)
	private String cpf;
	
	@Column(length =13 ) 
	private String telefone;

	@Column
	private int idade;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id" )
	private Endereco endereco;
	
	public Aluno() {
		
	}
	
	public Aluno(String nome, String cpf, String telefone, int idade, Endereco endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.idade = idade;
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

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cPF) {
		cpf = cPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Nome: "+nome+
				"\nCPF: "+cpf+
				"\nIdade: "+idade+
				"\nTelefone: "+telefone+
				"\nEndereço: "+endereco.getRua()+" "+endereco.getBairro()+" "+endereco.getCidade()+"\n";
	}
}