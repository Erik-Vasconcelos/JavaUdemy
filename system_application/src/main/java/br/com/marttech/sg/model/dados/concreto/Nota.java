package br.com.marttech.sg.model.dados.concreto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.marttech.sg.model.dto.NotaDTO;
import br.com.marttech.sg.model.perfis.abstracts.Servidor;

@Entity
public class Nota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	
	private LocalDate dataEntrega;
	
	private String anotacao;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Servidor servidor;
	
	public Nota() {
		
	}
	
	public Nota(NotaDTO notaDTO) {
		this.id = notaDTO.getId();
		this.titulo = notaDTO.getTitulo();
		this.dataEntrega = notaDTO.getDataEntrega();
		this.anotacao = notaDTO.getAnotacao();
		this.servidor = notaDTO.getServidor();
	}

	public Nota(String titulo, LocalDate dataEntrega, String anotacao, Servidor servidor) {
		this.titulo = titulo;
		this.dataEntrega = dataEntrega;
		this.anotacao = anotacao;
		this.servidor = servidor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getAnotacao() {
		return anotacao;
	}

	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
	
}
