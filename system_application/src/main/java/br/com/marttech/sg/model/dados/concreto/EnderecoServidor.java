package br.com.marttech.sg.model.dados.concreto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.marttech.sg.model.dados.abstrato.Endereco;
import br.com.marttech.sg.model.dados.enuns.Estado;
import br.com.marttech.sg.model.perfis.abstracts.Servidor;

@Entity
public class EnderecoServidor extends Endereco{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "id_usuario", unique = true, nullable = false)
	private Servidor servidor;
	
	public EnderecoServidor() {
		
	}
	
	public EnderecoServidor(String rua, String bairro, String cidade, Integer numero, Estado estado, Servidor servidor) {
		super(rua, bairro, cidade, numero, estado);
		this.servidor = servidor;
		servidor.setEndereco(this);
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

}
