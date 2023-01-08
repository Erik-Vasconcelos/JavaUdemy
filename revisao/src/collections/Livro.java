package collections;

public class Livro {
	private String nome;
	private String autor;
	private int isbn;
	
	public Livro(String nome, String autor) {
		super();
		this.nome = nome;
		this.autor = autor;
	}
	
	public Livro(String nome, String autor, int isbn) {
		super();
		this.nome = nome;
		this.autor = autor;
		this.isbn = isbn;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return String.format("Nome: %s Autor: %s Isbn: %d%n", nome, autor, isbn);
	}
	
	
	
}
