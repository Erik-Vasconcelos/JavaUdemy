package br.com.marttech.sg.model.dto;

import java.time.LocalDate;

import br.com.marttech.sg.model.dados.concreto.Nota;
import br.com.marttech.sg.model.perfis.abstracts.Servidor;

public class NotaDTO {
	
	private Long id;
	private String titulo;
	private LocalDate dataEntrega;
	private String anotacao;
	private Servidor servidor;
	
	public NotaDTO(Nota nota) {
		this.id = nota.getId();
		this.titulo = nota.getTitulo();
		this.dataEntrega = nota.getDataEntrega();
		this.anotacao = nota.getAnotacao();
		this.servidor = nota.getServidor();
	}
	
	public NotaDTO(Long id, String titulo, LocalDate dataEntrega, String anotacao) {
		this.id = id;
		this.titulo = titulo;
		this.dataEntrega = dataEntrega;
		this.anotacao = anotacao;
	}
	
	public NotaDTO(String titulo, LocalDate dataEntrega, String anotacao) {
		this.titulo = titulo;
		this.dataEntrega = dataEntrega;
		this.anotacao = anotacao;
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
