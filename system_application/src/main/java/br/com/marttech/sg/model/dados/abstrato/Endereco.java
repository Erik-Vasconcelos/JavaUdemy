package br.com.marttech.sg.model.dados.abstrato;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import br.com.marttech.sg.model.dados.enuns.Estado;
import br.com.marttech.sg.model.perfis.abstracts.Usuario;

@MappedSuperclass
public abstract class Endereco {
	
	@Column(nullable = false)
	private String rua;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false)
	private Integer numero;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Estado estado;
	
	
	public Endereco() {
	}

	public Endereco(String rua, String bairro, String cidade, Integer numero, Estado estado) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
		this.estado = estado;
	}

	
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	

	
}