package collections.projetinho.model;

import java.util.Objects;

public class Livro {
	private String nome;
	private String nomeAutor;
	private double preco;
	private Long isbn;
	
	public Livro(String nome, String nomeAutor, double preco, Long isbn) {
		super();
		this.nome = nome;
		this.nomeAutor = nomeAutor;
		this.preco = preco;
		this.isbn = isbn;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s%nR$%.2f isbn: %d%n\n", nome, nomeAutor, preco, isbn);
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn, nome, nomeAutor, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(isbn, other.isbn) && Objects.equals(nome, other.nome)
				&& Objects.equals(nomeAutor, other.nomeAutor)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
	}
	
	
}
