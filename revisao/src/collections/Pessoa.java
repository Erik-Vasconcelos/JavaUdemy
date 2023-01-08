package collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.SortedSet;

import classes_e_metodos.Date;

public class Pessoa {
	
	private String nome;
	private Date dataNascimento;
	private int idade;
	private ArrayList<Produto> produtos = new ArrayList<>(); 
	
	public Pessoa(String nome, Date dataNascimento, List<Produto> produtos) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.produtos.addAll(produtos);
		processarIdade();
	}
	
	

	public Pessoa(String nome, Date dataNascimento) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}



	private void processarIdade() {
		this.idade = LocalDate.now().getYear() - dataNascimento.getAno();
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "[Nome = " + nome + ", Data Nascimento = " + dataNascimento.displayDate()+
				", idade = " + idade + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataNascimento, idade, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(dataNascimento, other.dataNascimento) && idade == other.idade
				&& Objects.equals(nome, other.nome);
	}
	
	public double getValorCompra() {
		double total= 0.0;
		for (Produto produto : produtos) {
			total += produto.getPreco();
		}
		return total;
	}



	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	
	
	
}
