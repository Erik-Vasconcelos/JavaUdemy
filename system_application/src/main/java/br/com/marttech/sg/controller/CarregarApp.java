package br.com.marttech.sg.controller;

import br.com.marttech.sg.model.infra.DAOServidor;

public class CarregarApp {
	
	public static void startHibernate() {
		DAOServidor dao = new DAOServidor();
		dao.startHbernate();
	}
	
	public static long verificarUsuario() {
		DAOServidor dao = new DAOServidor();
		return dao.verificarQtdUsuarios();
	}
}
