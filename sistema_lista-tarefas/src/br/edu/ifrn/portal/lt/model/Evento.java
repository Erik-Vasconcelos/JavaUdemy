package br.edu.ifrn.portal.lt.model;

import java.sql.Date;
import java.util.Calendar;

public class Evento {
	
	private Long id;
	private String titulo;
	private String descricao;
	private Date dtaCriacao;
	private Date dtaEntrega;
	@SuppressWarnings("unused")
	private boolean concluido;
	
	public Evento() {
	}
	
	public Evento(Long id, String titulo, String descricao, Date dtaCriacao, Date dtaEntrega, boolean concluido) {
		this(titulo, descricao,dtaCriacao, dtaEntrega, concluido);
		this.id = id;
	}

	public Evento(String titulo, String descricao, Date dtaCriacao, Date dtaEntrega, boolean concluido) {
		this(titulo, descricao, dtaEntrega, concluido);
		this.dtaCriacao = dtaCriacao;
	}
	
	public Evento(String titulo, String descricao, Date dtaEntrega, boolean concluido) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.dtaEntrega = dtaEntrega;
		this.concluido = concluido;
		
		Calendar calendario = Calendar.getInstance();
		calendario.add(Calendar.DAY_OF_MONTH, 0);
		this.dtaCriacao = new Date(calendario.getTimeInMillis());
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDtaCriacao() {
		return dtaCriacao;
	}
	public void setDtaCriacao(Date dtaCriacao) {
		this.dtaCriacao = dtaCriacao;
	}
	public Date getDtaEntrega() {
		return dtaEntrega;
	}
	public void setDtaEntrega(Date dtaEntrega) {
		this.dtaEntrega = dtaEntrega;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Evento [titulo=" + titulo + ", descricao=" + descricao + ", dtaCriacao=" + dtaCriacao + ", dtaEntrega="
				+ dtaEntrega + ", concluido=" + (concluido ? "Concluido": "Não concluido") + "]";
	};
}
