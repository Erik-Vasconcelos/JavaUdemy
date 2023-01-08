package br.edu.ifrn.portal.lv.model;

import java.util.Objects;

public abstract class Livro {
	private Long isbn;
	private String titulo;
	private String nomeAutor;
	private double preco;
	private int anoPublicacao;
	
	public Livro(Long isbn, String nome, String nomeAutor, double preco, int anoPublicacao) {
		super();
		this.isbn = isbn;
		this.titulo = nome;
		this.nomeAutor = nomeAutor;
		this.preco = preco;
		this.anoPublicacao = anoPublicacao;
	}
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getNome() {
		return titulo;
	}
	public void setNome(String nome) {
		this.titulo = nome;
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
		return String.format("%s %s%nR$%.2f isbn: %d%n\n", titulo, nomeAutor, preco, isbn);
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn, titulo, nomeAutor, preco);
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
		return Objects.equals(isbn, other.isbn) && Objects.equals(titulo, other.titulo)
				&& Objects.equals(nomeAutor, other.nomeAutor)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
	}
	
	
}
