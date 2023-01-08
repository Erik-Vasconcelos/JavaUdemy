package br.com.marttech.sg.model.dados;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.marttech.sg.model.dados.enuns.TipoTelefone;
import br.com.marttech.sg.model.perfis.abstracts.Usuario;

@Entity
public class Telefone{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String numero;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoTelefone tipo;
	
	@OneToOne
	@JoinColumn(name = "id_usuario", unique = true, nullable = false)
	private Usuario usuario;
	
	public Telefone() {
	}

	public Telefone(String numero, TipoTelefone tipo, Usuario usuario) {
		super();
		this.numero = numero;
		this.tipo = tipo;
		this.usuario = usuario;
		this.usuario.setTelefone(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Telefone [numero=" + numero + ", tipo=" + tipo + ", usuario=" + usuario + "]";
	}
	
	
}
