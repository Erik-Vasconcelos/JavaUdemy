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

import br.com.marttech.sg.model.dados.enuns.TipoTelefone;
import br.com.marttech.sg.model.perfis.abstracts.Servidor;

@MappedSuperclass
public abstract class Telefone{

	@Column(nullable = false, unique = true)
	private String numero;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoTelefone tipo;
	
	
	public Telefone() {
	}

	public Telefone(String numero, TipoTelefone tipo) {
		this.numero = numero;
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Telefone [numero=" + numero + ", tipo=" + tipo + "]";
	}


	
}
