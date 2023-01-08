package br.com.marttech.sg.model.dados.concreto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.marttech.sg.model.dados.abstrato.Telefone;
import br.com.marttech.sg.model.dados.enuns.TipoTelefone;
import br.com.marttech.sg.model.perfis.abstracts.Servidor;

@Entity
public class TelefoneServidor extends Telefone{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "id_usuario", unique = true, nullable = false)
	private Servidor servidor;
	
	public TelefoneServidor() {
		
	}
	
	public TelefoneServidor(String numero, TipoTelefone tipo, Servidor usuario) {
		super(numero, tipo);
		this.servidor = usuario;
		this.servidor.setTelefone(this);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Servidor getUsuario() {
		return servidor;
	}

	public void setUsuario(Servidor usuario) {
		this.servidor = usuario;
	}
	
}
