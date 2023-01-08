package br.edu.ifrn.portal.lt.controller;

import java.sql.Date;
import java.sql.SQLException;

import br.edu.ifrn.portal.lt.infra.DAO;
import br.edu.ifrn.portal.lt.model.Evento;

public class Systema {
	
	private DAO dao = new DAO();
	
	public int cadastrar(String titulo, String descricao, Date dtaEntrega) {
		try {
			if (Validar.Texto(titulo) && Validar.Texto(descricao)) {
				
				Evento evento = new Evento();
				return dao.create(evento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public StringBuilder visualizar(String valor) {
		try {
			Evento evento = new Evento();
			evento = dao.read(valor);
			StringBuilder result = new StringBuilder();
			
			if(evento != null) {
				result.append("Id: "+evento.getId());
				result.append("Titulo: "+evento.getTitulo());
				result.append("Descricao: "+evento.getDescricao());
				result.append("Data de criação: "+evento.getDtaCriacao());
				result.append("Data de Entrega: "+evento.getDtaEntrega());
				result.append("Status: "+ (evento.isConcluido() == true? "Concluido": "Não concluido"));
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new StringBuilder();
	}
	
	
//	private StringBuilder concatValores(String buiString, eve) {
//		
//	}
}
