package strem_api;

import java.util.Objects;

public class Produto {
	final String nome;
	final String marca;
	final int tempodeLancamentoDias;
	
	public Produto(String nome, String marca, int tempodeLancamentoDias) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.tempodeLancamentoDias = tempodeLancamentoDias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(marca, nome, tempodeLancamentoDias);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(marca, other.marca) && Objects.equals(nome, other.nome)
				&& tempodeLancamentoDias == other.tempodeLancamentoDias;
	}
	
	
}
